package com.vacvn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.vacvn.model.MedicalRecordModel;
import com.vacvn.model.VaccineModel;
import com.vacvn.utils.JsonConverter;



public class MedicalRecordMapper implements IMapper<MedicalRecordModel> {
	@Override
	public MedicalRecordModel mapRow(ResultSet resultSet) {
		try {
			MedicalRecordModel medicalRecord = new MedicalRecordModel();
			medicalRecord.setSTT(resultSet.getLong("STT"));
			medicalRecord.setDate(resultSet.getString("date"));
			medicalRecord.setAddress(resultSet.getString("address"));
			VaccineModel vaccine = new VaccineModel();
			vaccine.setId(resultSet.getLong("vaccineid"));
			vaccine.setVaccineName(resultSet.getString("vaccinename"));
			
			medicalRecord.setVaccine(vaccine);
			return medicalRecord;
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public MedicalRecordModel mapJson(JSONObject jsonObject) {

		try {
			MedicalRecordModel medicalRecord = new MedicalRecordModel();
			if(jsonObject.has("STT")) 
				medicalRecord.setSTT(jsonObject.getLong("STT"));
			if(jsonObject.has("address"))
				medicalRecord.setAddress(jsonObject.getString("address"));
			medicalRecord.setDate(jsonObject.getString("injectiondate"));
			JsonConverter jc = new JsonConverter(jsonObject.get("vaccine").toString());
			System.out.println(jsonObject.get("vaccine"));
			VaccineModel vaccine = jc.toModel(VaccineModel.class);
			medicalRecord.setVaccine(vaccine);
			return medicalRecord;
		} catch (JSONException | ParseException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
}
