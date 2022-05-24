package com.vacvn.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicalRecordModel {
	private Long STT;

	private VaccineModel vaccine;

	private String address;

	private Date date;

	public Long getSTT() {
		return STT;
	}

	public void setSTT(Long STT) {
		this.STT = STT;
	}

	public VaccineModel getVaccine() {
		return vaccine;
	}

	public void setVaccine(VaccineModel vaccine) {
		this.vaccine = vaccine;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}

	public void setDate(String date) throws ParseException {
		this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}

	@Override
	public String toString() {
		return "MedicalRecordModel [STT=" + STT + ", vaccine=" + vaccine + ", address=" + address + ", date=" + date
				+ "]";
	}

}
