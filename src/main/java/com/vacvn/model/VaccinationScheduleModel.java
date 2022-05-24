package com.vacvn.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VaccinationScheduleModel extends AbstractModel<VaccinationScheduleModel> {

	private Long id;

	private String address;

	@JsonProperty("vcsdate")
	private Date date;

	private Long amount;

	private String day;

	private Boolean status;

	private VaccineModel vaccine;

	private List<UserModel> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

	public VaccineModel getVaccine() {
		return vaccine;
	}

	public void setVaccine(VaccineModel vaccine) {
		this.vaccine = vaccine;
	}

	@Override
	public String toString() {
		return "VaccinationScheduleModel [id=" + id + ", address=" + address + ", date=" + date + ", amount=" + amount
				+ ", day=" + day + ", status=" + status + ", vaccine=" + vaccine + ", users=" + users + "]";
	}

}
