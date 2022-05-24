package com.vacvn.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vacvn.model.AdminModel;
import com.vacvn.service.IAdminService;

@WebServlet(urlPatterns = "/admin/login", name = "AdminLoginController")
public class LoginController  extends HttpServlet {

	@Inject
	private IAdminService adminService;
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (req.getParameter("logout") != null) {
			System.out.println("logout");
			session.invalidate();
			resp.sendRedirect(req.getContextPath() +  "/admin/login");
			return;
		} else if (session.getAttribute("admin") != null) {
			resp.sendRedirect(req.getContextPath() + "/admin/home");
			System.out.println(1);
			return;
		}
		req.setAttribute("loginFailed", false);
		req.getRequestDispatcher("/views/admin/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		AdminModel admin = adminService.findByAdminnameAndPassword(username, password);
		System.out.println(admin);
		if(admin != null) {
			session.setAttribute("admin", admin);
			resp.sendRedirect(req.getContextPath() + "/admin/home");
		}
		else {
			req.setAttribute("loginFailed", true);
			req.getRequestDispatcher("/views/admin/login.jsp").forward(req, resp);
		}
	}
}



