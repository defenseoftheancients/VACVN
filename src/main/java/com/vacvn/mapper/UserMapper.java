package com.vacvn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.vacvn.model.UserModel;


public class UserMapper implements IMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getString("id"));
			user.setFullName(resultSet.getString("fullname"));
			user.setDob(resultSet.getString("dob"));
			user.setAddress(resultSet.getString("address"));
			user.setGender(resultSet.getString("gender"));
			user.setProvinceCode(resultSet.getString("provincecode"));
			
			
			
			return user;
		} catch (SQLException | ParseException e) {
			return null;
		}	
	}

	@Override
	public UserModel mapJson(JSONObject jsonObject)  {
		try {
			UserModel user = new UserModel();
			user.setId(jsonObject.getString("id"));
			user.setFullName(jsonObject.getString("fullName"));
			if(jsonObject.has("email"))
				user.setEmail(jsonObject.getString("email"));
			if(jsonObject.has("address"))
				user.setAddress(jsonObject.getString("address"));
			user.setGender(jsonObject.getString("gender"));
			if(jsonObject.has("provinceCode"))
				user.setProvinceCode(jsonObject.getString("provinceCode"));
			user.setDob(jsonObject.getString("dob"));
			
			return user;
		} catch (JSONException | ParseException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
