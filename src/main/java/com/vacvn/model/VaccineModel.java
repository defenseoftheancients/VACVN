package com.vacvn.model;

public class VaccineModel {
	private Long id;
	private String vaccineName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	@Override
	public String toString() {
		return "vaccineModel [id=" + id + ", vaccinename=" + vaccineName + "]";
	}
	
	
}
