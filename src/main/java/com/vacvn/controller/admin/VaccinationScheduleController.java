package com.vacvn.controller.admin;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
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
import com.vacvn.model.VaccineModel;
import com.vacvn.service.IVaccinationScheduleService;
import com.vacvn.service.IVaccineService;
import com.vacvn.utils.JsonConverter;

@WebServlet(urlPatterns = "/admin/vaccinationschedule", name = "AdminVaccinationsSheduleController")
public class VaccinationScheduleController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IVaccinationScheduleService vaccinationScheduleService;
	
	@Inject
	private IVaccineService vaccineService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		Long id = req.getParameter("id") == null ? null : Long.parseLong(req.getParameter("id"));
		List<VaccineModel> vaccines = vaccineService.findAll();
		req.setAttribute("vaccines", vaccines);
		if(id != null) {
			List<UserModel> registeredUser = vaccinationScheduleService.findAllRegisteredUser(id);
			VaccinationScheduleModel vaccinationSchedule = vaccinationScheduleService.findOne(id);
			vaccinationSchedule.setUsers(registeredUser);
			req.setAttribute("vaccinationschedule", vaccinationSchedule);
			req.getRequestDispatcher("/views/admin/vaccinationschedule-edit.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("vaccinationschedules", vaccinationScheduleService.findAll());
			req.getRequestDispatcher("/views/admin/vaccinationschedule.jsp").forward(req, resp);
		}
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		JsonConverter jc = JsonConverter.of(req.getReader());
//		JSONObject jsonObject = new JSONObject(jc.getJsonString());
//		ObjectMapper objectMapper = new ObjectMapper();
//		UserModel user =  objectMapper.readValue(jsonObject.getString("user"), UserModel.class);
//		String authEncoded = Base64.getEncoder().encodeToString((new Date()).toString().getBytes());
//		System.out.println(user);
//	}
//	
	
}
