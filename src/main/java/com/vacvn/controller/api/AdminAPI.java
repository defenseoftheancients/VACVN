package com.vacvn.controller.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacvn.mapper.AdminMapper;
import com.vacvn.model.AdminModel;
import com.vacvn.service.IAdminService;
import com.vacvn.service.impl.AdminService;
import com.vacvn.utils.JsonConverter;

@WebServlet(urlPatterns = "/api/admins")
public class AdminAPI extends HttpServlet {
	@Inject
	private IAdminService adminService = new AdminService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Long id = Long.parseLong(req.getParameter("id"));
		System.err.println(id);
		AdminModel admin = adminService.findById(id);
		System.out.println(admin);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), admin);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		AdminModel admin = jc.toModel(new AdminMapper(), jsonObject);
		System.out.println(admin);
		admin = adminService.insert(admin);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), admin);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		AdminModel admin = jc.toModel(new AdminMapper(), jsonObject);
		admin = adminService.update(admin);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), admin);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		JsonConverter jc = JsonConverter.of(req.getReader());
		JSONObject jsonObject = new JSONObject(jc.getJsonString());
		AdminModel admin = jc.toModel(new AdminMapper(), jsonObject);
		adminService.delete(admin);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), "{}");
		
		
//		JSONObject jsonObject = new JSONObject(JsonConverter.of(req.getReader()).getJsonString());
//		JSONArray jsonArray = jsonObject.getJSONArray("ids");
//		System.out.println(jsonArray.toList());
//		List<Long> ids = new ArrayList<>();
//		for (int i = 0; i < jsonArray.length(); i++)
//			ids.add(Long.parseLong(jsonArray.get(i).toString()));
//		adminService.deleteRows(ids);
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.writeValue(resp.getOutputStream(), "{}");
	}
}
