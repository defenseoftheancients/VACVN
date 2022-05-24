package com.vacvn.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.weld.context.http.Http;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacvn.mapper.UserMapper;
import com.vacvn.model.MedicalRecordModel;
import com.vacvn.model.UserModel;
import com.vacvn.model.VaccinationScheduleModel;
import com.vacvn.service.IMedicalRecordService;
import com.vacvn.service.IUserService;
import com.vacvn.service.IVaccinationScheduleService;
import com.vacvn.service.impl.UserService;
import com.vacvn.utils.JsonConverter;

@WebServlet(urlPatterns = "/api/users")
public class UserAPI extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;

	@Inject
	private IMedicalRecordService medicalRecordService;
	
	@Inject
	private IVaccinationScheduleService vaccinationScheduleService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String json = URLDecoder.decode(req.getParameter("id").replace("+", "%2B"), "UTF-8")
        .replace("%2B", "+");
		System.out.println(json);
		
		JsonConverter jc = new JsonConverter(json);
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		UserModel user = jc.toModel(new UserMapper(), jsonObject);
		System.out.println(user);
		user = userService.findByAllInfor(user);
		ObjectMapper objectMapper = new ObjectMapper();
		if(user != null) {
			List<MedicalRecordModel> medicalRecords = medicalRecordService.findByUserId(user.getId());
			List<VaccinationScheduleModel> vaccinationSchedules = vaccinationScheduleService.findByUserId(user.getId());
			user.setMedicalRecords(medicalRecords);
			user.setVaccinationSchedules(vaccinationSchedules);
			objectMapper.writeValue(resp.getOutputStream(), user);
		}
		else
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel user = JsonConverter.of(req.getReader()).toModel(UserModel.class);
		user = userService.insert(user);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), user);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		UserModel user = jc.toModel(new UserMapper(), jsonObject);
		user = userService.update(user);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), user);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		System.out.println(jc.getJsonString());
		UserModel user = jc.toModel(new UserMapper(), jsonObject);
		System.out.println(user);
		userService.deleteByid(user.getId());
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), "{}");
//		JSONObject jsonObject = new JSONObject(JsonConverter.of(req.getReader()).getJsonString());
//		JSONArray jsonArray = jsonObject.getJSONArray("ids");
//		System.out.println(jsonArray.toList());
//		List<Long> ids = new ArrayList<>();
//		for (int i = 0; i < jsonArray.length(); i++)
//			ids.add(Long.parseLong(jsonArray.get(i).toString()));
//		userService.deleteRows(ids);
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.writeValue(resp.getOutputStream(), "{}");
	}
}
