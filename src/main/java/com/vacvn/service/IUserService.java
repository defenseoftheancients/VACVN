package com.vacvn.service;

import java.util.List;

import com.vacvn.model.AdminModel;
import com.vacvn.model.UserModel;

public interface IUserService {
	List<UserModel> findAll(AdminModel admin);
	UserModel findByid(String id);
	UserModel findByAllInfor(UserModel userModel);
	UserModel insert(UserModel user);
	UserModel update(UserModel user);
	void deleteByidsIn(List<String> ids);
	void deleteByid(String id);
	
}
