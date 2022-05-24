package com.vacvn.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vacvn.utils.UserUtil;

public class UserModel {

	private String id;

	private String fullName;

	private Date dob;

	private String gender;

	private String address;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String provinceCode;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String email;

	public UserModel() {

	}

	List<MedicalRecordModel> medicalRecords = new ArrayList<>();

	List<VaccinationScheduleModel> vaccinationSchedules = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = UserUtil.formatString(provinceCode, 3) + UserUtil.getGenderCode(gender, this.getDob()).toString()
				+ getDob().substring(8, 10) + UserUtil.formatString(id.toString(), 6);
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dob);
	}

	public void setDob(String dob) throws ParseException {
		this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public List<MedicalRecordModel> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecordModel> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public List<VaccinationScheduleModel> getVaccinationSchedules() {
		return vaccinationSchedules;
	}

	public void setVaccinationSchedules(List<VaccinationScheduleModel> vaccinationSchedules) {
		this.vaccinationSchedules = vaccinationSchedules;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", gender=" + gender + ", address="
				+ address + ", provinceCode=" + provinceCode + ", medicalrecords=" + medicalRecords + "]";
	}

}
