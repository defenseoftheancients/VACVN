package com.vacvn.utils;

public class UserUtil {
	public static String formatString(String arg, int length) {
		String tmp = "0".repeat(length);
		String result = arg.length() == length ? arg : (tmp + arg).substring(arg.length());
		return result;
	}
	
	public static Integer getGenderCode(String gender, String dob){
        int year_DOB = Integer.parseInt(dob.substring(6, 10));
        int tmp = (year_DOB - 1900)/100;
        if(gender.equals("Nam"))    
        	return tmp*2;
        else return tmp*2+1;
    }
}
