package com.vacvn.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.vacvn.dao.IAdminDAO;
import com.vacvn.model.AdminModel;
import com.vacvn.service.IAdminService;
import com.vacvn.utils.HashUtil;

public class AdminService implements IAdminService {

	@Inject
	private IAdminDAO adminDAO;

	@Override
	public List<AdminModel> findAll() {
		return adminDAO.findAll();
	}

	@Override
	public AdminModel findById(Long id) {
		return adminDAO.findById(id);
	}

	@Override
	public AdminModel insert(AdminModel admin) {
		admin.setPassword(HashUtil.get_SHA_512_SecurePassword(admin.getPassword()));
		Long id = adminDAO.insert(admin);
		return adminDAO.findById(id);
	}

	@Override
	public AdminModel update(AdminModel admin) {
		adminDAO.update(admin);
		return adminDAO.findById(admin.getId());
	}

	@Override
	public void deleteRows(List<Long> ids) {
		adminDAO.deleteRows(ids);
	}

	@Override
	public void delete(AdminModel admin) {
		adminDAO.delete(admin);
	}

	@Override
	public AdminModel findByAdminnameAndPassword(String adminname, String password) {
//		HashUtil.get_SHA_512_SecurePassword(password)
		return adminDAO.findByAdminnameAndPassword(adminname, HashUtil.get_SHA_512_SecurePassword(password));
	}

}
