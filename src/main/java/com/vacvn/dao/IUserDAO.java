package com.vacvn.dao;

import java.util.List;

import com.vacvn.model.AdminModel;
import com.vacvn.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{
	List<UserModel> findAll(AdminModel admin);
	UserModel findByid(String id);
	UserModel findByAllInfor(UserModel userModel);
	Long countByProvinceCode(String proviceCode);
	void insert(UserModel user);
	void update(UserModel user);
	void deleteByIdsIn(List<String> ids);
	void deleteById(String id);
}
