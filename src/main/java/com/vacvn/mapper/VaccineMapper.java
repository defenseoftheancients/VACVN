package com.vacvn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;
import com.vacvn.model.VaccineModel;

public class VaccineMapper implements IMapper<VaccineModel> {

	@Override
	public VaccineModel mapRow(ResultSet resultSet) {
		try {
			VaccineModel vaccine = new VaccineModel();
			vaccine.setId(resultSet.getLong("id"));
			vaccine.setVaccineName(resultSet.getString("vaccinename"));
			return vaccine;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public VaccineModel mapJson(JSONObject jsonObject) {
		try {
			VaccineModel vaccine = new VaccineModel();
			vaccine.setId(jsonObject.getLong("id"));
			vaccine.setVaccineName(jsonObject.getString("vaccineName"));
			return vaccine;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

}
