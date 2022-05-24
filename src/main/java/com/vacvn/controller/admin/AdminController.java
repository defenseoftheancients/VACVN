package com.vacvn.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vacvn.model.AdminModel;
import com.vacvn.service.IAdminService;

@WebServlet(urlPatterns = "/admin/admin", name = "AdminController")
public class AdminController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private IAdminService adminService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AdminModel> admins = adminService.findAll();
		req.setAttribute("admins", admins);
		req.getRequestDispatcher("/views/admin/admin.jsp").forward(req, resp);
		
	}
}
