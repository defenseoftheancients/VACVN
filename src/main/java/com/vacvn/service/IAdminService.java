package com.vacvn.service;

import java.util.List;

import com.vacvn.model.AdminModel;


public interface IAdminService {
	List<AdminModel> findAll();
	AdminModel findById(Long id);
	AdminModel findByAdminnameAndPassword(String adminname, String password);
	AdminModel insert(AdminModel admin);
	AdminModel update(AdminModel admin);
	void deleteRows(List<Long> ids);
	void delete(AdminModel admin);
}
