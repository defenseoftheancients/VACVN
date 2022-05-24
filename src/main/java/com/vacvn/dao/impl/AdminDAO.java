package com.vacvn.dao.impl;

import java.util.List;

import com.vacvn.dao.IAdminDAO;
import com.vacvn.mapper.AdminMapper;
import com.vacvn.mapper.UserMapper;
import com.vacvn.model.AdminModel;
import com.vacvn.model.UserModel;

public class AdminDAO extends AbstractDao<AdminModel> implements IAdminDAO {

	@Override
	public List<AdminModel> findAll() {
		String queryString = "SELECT admin.*, rolename FROM admin, role "
				+ "WHERE role.id = admin.roleid";
		List<AdminModel> results = query(queryString, new AdminMapper());
		return results.isEmpty() ? null : results;
	}
	
	@Override
	public AdminModel findById(Long id) {
		String queryString = "SELECT admin.*, rolename FROM admin, role "
				+ "WHERE admin.id = ? and role.id = admin.roleid";
		List<AdminModel> results = query(queryString, new AdminMapper(), id);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public Long insert(AdminModel admin) {
		String queryString = "INSERT INTO admin (adminname, fullname, gender, password, roleid, provincecode)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		return insert(queryString, admin.getAdminName(), admin.getFullName(),admin.getGender(), admin.getPassword(), admin.getRole().getId(), admin.getProvinceCode());
	}

	@Override
	public void update(AdminModel admin) {
		String queryString = null;
		if(admin.getPassword() != null) {
			queryString = "UPDATE admin SET fullname = ?, gender = ?, password = ?, roleid = ?, provincecode = ? WHERE id = ?";
			update(queryString, admin.getFullName(), admin.getGender(), admin.getPassword(), admin.getRole().getId(), admin.getProvinceCode(), admin.getId());
		}
		else {
			queryString = "UPDATE admin SET fullname = ?, gender = ?, roleid = ?, provincecode = ? WHERE id = ?";
			update(queryString, admin.getFullName(), admin.getGender(), admin.getRole().getId(), admin.getProvinceCode(), admin.getId());
		}
	}

	@Override
	public void deleteRows(List<Long> ids) {
		String queryString = "DELETE from admin WHERE id IN (";
		int i = 0;
		for(i = 0;i < ids.size()-1;i++) 
			queryString += ids.get(i).toString() + ", ";
		queryString += ids.get(i).toString() + ")";
		update(queryString);
	}
	@Override
	public void delete(AdminModel admin) {
		String queryString = "DELETE from admin WHERE id = ?";
		update(queryString, admin.getId());
		
	}
	@Override
	public AdminModel findByAdminnameAndPassword(String adminname, String password) {
		String queryString = "SELECT admin.*, rolename FROM admin, role "
				+ "WHERE admin.adminname = ? and admin.password = ? and role.id = admin.roleid";
		List<AdminModel> results = query(queryString, new AdminMapper(), adminname, password);
		return results.isEmpty() ? null : results.get(0);
	}

	

	

	

}
