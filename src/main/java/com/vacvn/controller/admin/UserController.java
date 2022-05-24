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
import com.vacvn.model.MedicalRecordModel;
import com.vacvn.model.UserModel;
import com.vacvn.model.VaccineModel;
import com.vacvn.service.IMedicalRecordService;
import com.vacvn.service.IUserService;
import com.vacvn.service.IVaccineService;


@WebServlet(urlPatterns = "/admin/user", name = "AdminUserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IUserService userService;
	
	@Inject
	private IMedicalRecordService medicalRecordService;
	
	@Inject
	private IVaccineService vaccineService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String id = req.getParameter("id");
		AdminModel admin = (AdminModel) req.getSession().getAttribute("admin");
		if(id != null) {
			UserModel user =  userService.findByid(req.getParameter("id"));
			if(user == null) {
				req.setAttribute("users", userService.findAll(admin));
				req.getRequestDispatcher("/views/admin/user.jsp").forward(req, resp);
			}
			else if(admin.getProvinceCode().equals("") || admin.getProvinceCode().equals(user.getProvinceCode())) {
				List<MedicalRecordModel> medicalrecords = medicalRecordService.findByUserId(id);
				List<VaccineModel> vaccines = vaccineService.findAll();
				user.setMedicalRecords(medicalrecords);
				req.setAttribute("vaccines", vaccines);
				req.setAttribute("user", user);
				req.getRequestDispatcher("/views/admin/user-edit.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("users", userService.findAll(admin));
				req.getRequestDispatcher("/views/admin/user.jsp").forward(req, resp);
			}
		
		}
		else {
			req.setAttribute("users", userService.findAll(admin));
			req.getRequestDispatcher("/views/admin/user.jsp").forward(req, resp);
		}
		
	}
}

