package com.vacvn.controller.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacvn.model.VaccinationScheduleModel;
import com.vacvn.service.IVaccinationScheduleService;
import com.vacvn.utils.JsonConverter;

@WebServlet(urlPatterns = "/api/vaccinationschedules")
public class VaccinationScheduleAPI extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Inject
	private IVaccinationScheduleService vaccinationScheduleService;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address = req.getParameter("address");
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(address);
		List<VaccinationScheduleModel> vaccinationSchedules = vaccinationScheduleService.findByAddress(address);
		objectMapper.writeValue(resp.getOutputStream(), vaccinationSchedules);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		if(jsonObject.has("vaccinationscheduleid")) {
			vaccinationScheduleService.insert(jsonObject.getLong("vaccinationscheduleid"), jsonObject.getString("userid"));
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(resp.getOutputStream(), "{}");
		}
		else {
			VaccinationScheduleModel vaccinationSchedule = jc.toModel(VaccinationScheduleModel.class);
			System.out.println(vaccinationSchedule);
			vaccinationSchedule = vaccinationScheduleService.insert(vaccinationSchedule, jsonObject.getLong("adminid"));
			System.out.println(vaccinationSchedule);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(resp.getOutputStream(), vaccinationSchedule);
		}
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		VaccinationScheduleModel vaccinationSchedule = jc.toModel(VaccinationScheduleModel.class);
		System.out.println(vaccinationSchedule);
		vaccinationSchedule = vaccinationScheduleService.update(vaccinationSchedule, jsonObject.getLong("adminid"));
		System.out.println(vaccinationSchedule);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), vaccinationSchedule);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		if(jsonObject.has("vaccinationscheduleid")) 
			vaccinationScheduleService.delete(jsonObject.getLong("vaccinationscheduleid"), jsonObject.getString("userid"));
		else {
			
			VaccinationScheduleModel vaccinationSchedule = jc.toModel(VaccinationScheduleModel.class);
			System.out.println(vaccinationSchedule);
			vaccinationScheduleService.delete(vaccinationSchedule);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), "{}");
	}
}
