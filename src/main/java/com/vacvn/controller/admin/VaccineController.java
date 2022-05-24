package com.vacvn.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vacvn.model.VaccineModel;
import com.vacvn.service.IVaccineService;

@WebServlet(urlPatterns = "/admin/vaccine", name = "AdminVaccineController")
public class VaccineController extends HttpServlet {

	@Inject
	private IVaccineService vaccineService;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VaccineModel> vaccines =  vaccineService.findAll();
		req.setAttribute("vaccines", vaccines);
		req.getRequestDispatcher("/views/admin/vaccine.jsp").forward(req, resp);
	}
}
