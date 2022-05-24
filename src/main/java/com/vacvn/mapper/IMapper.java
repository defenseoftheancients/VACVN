package com.vacvn.mapper;

import java.sql.ResultSet;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

public interface IMapper<T> {
	T mapRow(ResultSet resultSet) ;
	T mapJson(JSONObject jsonObject) ;
	
}
