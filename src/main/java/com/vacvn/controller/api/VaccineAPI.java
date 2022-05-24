package com.vacvn.controller.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacvn.model.VaccineModel;
import com.vacvn.service.IVaccineService;
import com.vacvn.utils.JsonConverter;


@WebServlet(urlPatterns = "/api/vaccines")
public class VaccineAPI extends HttpServlet {

	@Inject
	private IVaccineService vaccineService;
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		List<VaccineModel> vaccine = vaccineService.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), vaccine);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		VaccineModel vaccine = JsonConverter.of(req.getReader()).toModel(VaccineModel.class);
		System.out.println(vaccine);
		vaccine = vaccineService.insert(vaccine);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), vaccine);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		VaccineModel vaccine = JsonConverter.of(req.getReader()).toModel(VaccineModel.class);
		vaccine = vaccineService.update(vaccine);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), vaccine);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		VaccineModel vaccine = JsonConverter.of(req.getReader()).toModel(VaccineModel.class);
		System.out.println(vaccine);
		vaccineService.deleteById(vaccine);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(resp.getOutputStream(), "{}");
	}
}
