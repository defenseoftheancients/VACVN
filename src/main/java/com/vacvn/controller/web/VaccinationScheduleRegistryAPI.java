package com.vacvn.controller.web;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacvn.mapper.UserMapper;
import com.vacvn.model.UserModel;
import com.vacvn.model.VaccinationScheduleModel;
import com.vacvn.service.IUserService;
import com.vacvn.service.IVaccinationScheduleService;
import com.vacvn.utils.EmailUtility;
import com.vacvn.utils.JsonConverter;

@WebServlet(urlPatterns = "/api/vaccinationschedules/registry")
public class VaccinationScheduleRegistryAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserService userService;

	@Inject
	private IVaccinationScheduleService vaccinationScheduleService;

	private EmailUtility emailUtility;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		emailUtility = new EmailUtility(context.getInitParameter("host"), context.getInitParameter("port"),
				context.getInitParameter("user"), context.getInitParameter("pass"));

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		Long vaccinationScheduleId = Long.parseLong(req.getParameter("vaccinationscheduleid"));
		String userid = req.getParameter("userid");
		String authEncoded = req.getParameter("code");
		UserModel user = userService.findByid(req.getParameter("userid"));
		String content = "<script>" + "window.alert(\"[[message]] \\nNhấn OK để trở lại trang tra cứu!\");"
				+ "setTimeout(function() {"
				+ "		window.location.href = \"http://127.0.0.1:5500/UserUI/tracuu.html\" "
				+ "		}, 1000)</script>";

		if (user != null) {
			VaccinationScheduleModel vaccinationSchedule = vaccinationScheduleService.findOne(vaccinationScheduleId);
			if (vaccinationSchedule.getStatus() == true) {
				Object[] result = vaccinationScheduleService.findOne(vaccinationScheduleId, user.getId());
				Boolean isEnable = (Boolean) result[3];
				String vertification_code = (String) result[2];
				if (isEnable == true) {
					content = content.replace("[[message]]", "Đăng ký thành công!");
					System.out.println(1);
					resp.getWriter().println(content);

				} else if (vertification_code.equals(authEncoded)) {
					vaccinationScheduleService.insert(vaccinationScheduleId, userid, vertification_code, true);
					content = content.replace("[[message]]", "Đăng ký thành công!");
					resp.getWriter().println(content);
				} else {
					content = content.replace("[[message]]", "Đăng ký thất bại, mã code không hợp lệ!");
					resp.getWriter().println(content);
				}
			}
		} else {
			content = content.replace("[[message]]", "Đăng ký thất bại, thông tin không tồn tại!");
			resp.getWriter().println(content);
		}

		System.out.println(vaccinationScheduleId);
		System.out.println(userid);
		System.out.println(authEncoded);
//		resp.getWriter().println("Success");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());

		ObjectMapper objectMapper = new ObjectMapper();
		Long vaccinationScheduleId = Long.parseLong(jsonObject.getString("vaccinationScheduleId"));
		VaccinationScheduleModel vaccinationSchedule = vaccinationScheduleService.findOne(vaccinationScheduleId);
		UserModel user = jc.toModel(new UserMapper(), jsonObject.getJSONObject("user"));
		String email = user.getEmail();
		user = userService.findByAllInfor(user);
		if (user == null || vaccinationSchedule.getStatus() == false)
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		else {
			List<UserModel> registryUsers = vaccinationScheduleService
					.findAllRegisteredUser(vaccinationSchedule.getId());
			if (registryUsers.size() >= vaccinationSchedule.getAmount()) {
				objectMapper.writeValue(resp.getOutputStream(), "Lịch tiêm đã đăng ký hết!");
			} else {
				String authEncoded = Base64.getEncoder()
						.encodeToString(((new Date()).toString() + user.getId()).getBytes());

				Object[] result = vaccinationScheduleService
						.findOne(Long.parseLong(jsonObject.getString("vaccinationScheduleId")), user.getId());
				user.setEmail(email);
				if (result[0] != null && result[1] != null) {
					Boolean isEnable = (Boolean) result[3];
					if (isEnable == true) {
						objectMapper.writeValue(resp.getOutputStream(), "Bạn đã đăng ký lịch tiêm này rồi!");
					} else {
						vaccinationScheduleService.insert(vaccinationScheduleId, user.getId(), authEncoded, false);
						try {
							emailUtility.sendEmail(vaccinationScheduleId.toString(), user, authEncoded);
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						objectMapper.writeValue(resp.getOutputStream(), "Vui lòng kiểm tra email của bạn!");
					}
				} else {
					vaccinationScheduleService.insert(vaccinationScheduleId, user.getId(), authEncoded, false);
					try {
						emailUtility.sendEmail(jsonObject.getString("vaccinationScheduleId"), user, authEncoded);
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					objectMapper.writeValue(resp.getOutputStream(), "Vui lòng kiểm tra email của bạn!");
				}
			}

		}

	}

}
