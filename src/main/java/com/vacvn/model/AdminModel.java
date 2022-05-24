package com.vacvn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AdminModel extends AbstractModel<AdminModel> {
	private String adminName;

	private String fullName;

	private String gender;

	private String password;

	private RoleModel role;

	private String provinceCode;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	@Override
	public String toString() {
		return "AdminModel [adminName=" + adminName + ", fullName=" + fullName + ", gender=" + gender + ", password="
				+ password + ", role=" + role + ", provinceCode=" + provinceCode + "]";
	}

	

}
