package com.vacvn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.json.JSONObject;


import com.vacvn.model.VaccinationScheduleModel;
import com.vacvn.model.VaccineModel;

public class VaccinationScheduleMapper implements IMapper<VaccinationScheduleModel> {

	@Override
	public VaccinationScheduleModel mapRow(ResultSet resultSet) {
		
		try {
			VaccinationScheduleModel vaccinationSchedule = new VaccinationScheduleModel();
			vaccinationSchedule.setId(resultSet.getLong("id"));
			vaccinationSchedule.setAddress(resultSet.getString("address"));
			vaccinationSchedule.setDate(resultSet.getString("date"));
			vaccinationSchedule.setAmount(resultSet.getLong("amount"));
			vaccinationSchedule.setDay(resultSet.getString("day"));
			vaccinationSchedule.setStatus(resultSet.getBoolean("status"));
			VaccineModel vaccine = new VaccineModel();
			vaccine.setId(resultSet.getLong("vaccineid"));
			vaccine.setVaccineName(resultSet.getString("vaccinename"));
			vaccinationSchedule.setVaccine(vaccine);
			return vaccinationSchedule;
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public VaccinationScheduleModel mapJson(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}

}
