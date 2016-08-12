package com.kedu.staff.dto;

import java.util.Date;

public class StaffDto {
	private String userid;
	private String pwd;
	private String name;
	private String lev;
	private String phone;
	private Date enter;
	private Integer gender;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLev() {
		return lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnter() {
		return enter;
	}

	public void setEnter(Date enter) {
		this.enter = enter;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "StaffDto [id=" + userid + ", pwd=" + pwd + ", name=" + name + ", lev=" + lev + ", phone=" + phone
				+ ", gender=" + gender + "]";
	}

}
