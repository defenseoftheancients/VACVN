package com.vacvn.dao.impl;

import java.util.List;

import com.vacvn.dao.IUserDAO;
import com.vacvn.mapper.UserMapper;
import com.vacvn.model.AdminModel;
import com.vacvn.model.UserModel;

public class UserDAO extends AbstractDao<UserModel> implements IUserDAO {

	@Override
	public List<UserModel> findAll(AdminModel admin) {
		List<UserModel> results = null;
		String queryString = "";
		if(admin.getProvinceCode().equals("")) {
			queryString = "SELECT * FROM user";
			results = query(queryString, new UserMapper());
		}
		else {
			queryString = "SELECT * FROM user WHERE provincecode = ?";
			results = query(queryString, new UserMapper(), admin.getProvinceCode());
		}
		return results;
	}

	@Override
	public UserModel findByid(String id) {
		String queryString = "SELECT * FROM user WHERE id = ?";
		List<UserModel> results = query(queryString, new UserMapper(), id);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public UserModel findByAllInfor(UserModel userModel) {
		String queryString = "SELECT * FROM user WHERE id = ? and fullname = ? "
				+ "and dob = ? and address = ? and gender = ?";
		List<UserModel> results = query(queryString, new UserMapper(), userModel.getId(), userModel.getFullName(),
				userModel.getDob(), userModel.getAddress(), userModel.getGender());
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public void insert(UserModel user) {
		String queryString = "INSERT INTO user (id, fullname, dob, address, gender, provincecode) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		update(queryString, user.getId(), user.getFullName(), user.getDob(), user.getAddress(), user.getGender(),
				user.getProvinceCode());
	}

	@Override
	public void update(UserModel user) {
		String queryString = "UPDATE user SET fullname = ?, dob = ?, gender = ? WHERE id = ?";

		update(queryString, user.getFullName(), user.getDob(), user.getGender(), user.getId());

	}

	@Override
	public void deleteByIdsIn(List<String> ids) {
		String queryString = "DELETE from user WHERE id IN (";
		int i = 0;
		for (i = 0; i < ids.size() - 1; i++)
			queryString += ids.get(i).toString() + ", ";
		queryString += ids.get(i).toString() + ")";
		System.out.println(queryString);
		update(queryString);

	}

	@Override
	public void deleteById(String id) {
		String queryString = "DELETE from user WHERE id = ?";
		update(queryString, id);
	}

	@Override
	public Long countByProvinceCode(String proviceCode) {
		String queryString = "SELECT COUNT(*) FROM user WHERE provincecode = ?;";
		Object[] result = getAttribute(queryString, 1, proviceCode);
		return (Long) (result.length > 0 ? result[0] : null);
	}

}
