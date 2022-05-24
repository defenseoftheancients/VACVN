package com.vacvn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws ParseException {
		String x = String.format("%03d", 22) + "2".toString() + "01".toString()
		+ String.format("%06d", 1);
		System.out.println(x);
	}
}
