package com.vacvn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.vacvn.model.AdminModel;
import com.vacvn.model.RoleModel;
import com.vacvn.utils.JsonConverter;

public class AdminMapper implements IMapper<AdminModel> {
	@Override
	public AdminModel mapRow(ResultSet resultSet) {
		try {
			AdminModel admin = new AdminModel();
			admin.setId(resultSet.getLong("id"));
			admin.setAdminName(resultSet.getString("adminname"));
			admin.setFullName(resultSet.getString("fullname"));
			admin.setGender(resultSet.getString("gender"));
			admin.setPassword(resultSet.getString("password"));
			admin.setProvinceCode(resultSet.getString("provincecode"));
			try {
				RoleModel role = new RoleModel();
				role.setId(resultSet.getLong("roleid"));
				role.setRolename(resultSet.getString("rolename"));
				admin.setRole(role);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			return admin;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public AdminModel mapJson(JSONObject jsonObject)  {
		AdminModel admin = new AdminModel();
		try {
			if(jsonObject.has("id"))
				admin.setId(jsonObject.getLong("id"));
			admin.setAdminName(jsonObject.getString("adminName"));
			admin.setFullName(jsonObject.getString("fullName"));
			if(jsonObject.has("password"))
				admin.setPassword(jsonObject.getString("password"));
			admin.setProvinceCode(jsonObject.getString("provinceCode"));
			admin.setGender(jsonObject.getString("gender"));
			JsonConverter jc = new JsonConverter(jsonObject.get("role").toString());
			RoleModel role = jc.toModel(RoleModel.class);
			admin.setRole(role);
			return admin;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	
	}
}
