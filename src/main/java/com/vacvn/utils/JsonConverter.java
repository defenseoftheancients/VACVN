package com.vacvn.utils;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacvn.mapper.IMapper;
import com.vacvn.mapper.UserMapper;
import com.vacvn.model.UserModel;

public class JsonConverter {
	private String jsonString;
	public JsonConverter(String jsonString) {
		this.jsonString = jsonString;
	}
	
	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	public <T> T toModel(Class<T> argClass) {
		try {
			return new ObjectMapper().readValue(jsonString, argClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public <T> T toModel(IMapper<T> argMapper, JSONObject jsonObject) {
		try {
			return argMapper.mapJson(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static JsonConverter of(BufferedReader br) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
		    while ((line = br.readLine()) != null) {
		        sb.append(line);
		    }
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new JsonConverter(sb.toString());
		
	}

	
}
