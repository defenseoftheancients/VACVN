package com.vacvn.dao;

import java.util.List;

import com.vacvn.model.AdminModel;



public interface IAdminDAO extends IGenericDAO<AdminModel>{
	List<AdminModel> findAll();
	AdminModel findById(Long id);
	AdminModel findByAdminnameAndPassword(String adminname, String password);
	Long insert(AdminModel admin);
	void update(AdminModel admin);
	void deleteRows(List<Long> ids);
	void delete(AdminModel admin);
}
