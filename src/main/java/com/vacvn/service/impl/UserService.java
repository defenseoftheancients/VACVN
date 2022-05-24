package com.vacvn.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.vacvn.dao.IUserDAO;
import com.vacvn.model.AdminModel;
import com.vacvn.model.UserModel;
import com.vacvn.service.IUserService;

public class UserService implements IUserService {
	@Inject
	private IUserDAO userDAO;

	@Override
	public List<UserModel> findAll(AdminModel admin) {
		return userDAO.findAll(admin);
	}

	@Override
	public UserModel findByid(String id) {
		return userDAO.findByid(id);
	}

	@Override
	public UserModel findByAllInfor(UserModel userModel) {
	
		return userDAO.findByAllInfor(userModel);
	}

	@Override
	public UserModel insert(UserModel user) {
		Long newUserId = userDAO.countByProvinceCode(user.getProvinceCode());
		if (newUserId == null)
			newUserId = 0L;
		user.setId(newUserId + 1);
		userDAO.insert(user);
		return userDAO.findByid(user.getId());
	}

	@Override
	public UserModel update(UserModel user) {
		userDAO.update(user);
		return userDAO.findByid(user.getId());
	}

	@Override
	public void deleteByidsIn(List<String> ids) {
		userDAO.deleteByIdsIn(ids);
	}

	@Override
	public void deleteByid(String id) {
		userDAO.deleteById(id);
	}

}
