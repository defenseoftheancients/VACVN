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
import com.vacvn.mapper.MedicalRecordMapper;
import com.vacvn.model.MedicalRecordModel;
import com.vacvn.service.IMedicalRecordService;
import com.vacvn.utils.JsonConverter;

@WebServlet(urlPatterns = "/api/medicalrecords")
public class MedicalRecordAPI  extends HttpServlet{
	
	
	@Inject
	private IMedicalRecordService medicalRecordService;
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String id = req.getParameter("id");
		List<MedicalRecordModel> medicalRecords = medicalRecordService.findByUserId(id);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), medicalRecords);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		MedicalRecordModel medicalRecord = jc.toModel(new MedicalRecordMapper(), jsonObject);
//		System.out.println(medicalRecord);
		medicalRecord = medicalRecordService.insert(medicalRecord, jsonObject.getLong("adminid"),jsonObject.getString("userid"));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), medicalRecord);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		MedicalRecordModel medicalRecord = jc.toModel(new MedicalRecordMapper(), jsonObject);
		System.out.println(medicalRecord);
		medicalRecord = medicalRecordService.update(medicalRecord, jsonObject.getLong("adminid"),jsonObject.getString("userid"));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), medicalRecord);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		MedicalRecordModel medicalRecord = jc.toModel(new MedicalRecordMapper(), jsonObject);
		medicalRecordService.delete(medicalRecord, jsonObject.getLong("adminid"), jsonObject.getString("userid"));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), "{}");
	}
}
