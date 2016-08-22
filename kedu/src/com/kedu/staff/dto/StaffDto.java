package com.kedu.staff.dto;

import java.sql.Timestamp;

public class StaffDto {
	private String stfid;
	private String pwd;
	private String ismgr;
	private String stfnm;
	private String jumin;
	private String phone;
	private Timestamp entrydt;
	private Timestamp resigndt;
	private int salary;
	private String pic_img;
	private String pic_img_orn;
	private String address;
	private String add_detail;
	private Timestamp regdt;
	private String regnm;
	private int jobid;
	private int deptid;
	public String getStfid() {
		return stfid;
	}
	public void setStfid(String stfid) {
		this.stfid = stfid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIsmgr() {
		return ismgr;
	}
	public void setIsmgr(String ismgr) {
		this.ismgr = ismgr;
	}
	public String getStfnm() {
		return stfnm;
	}
	public void setStfnm(String stfnm) {
		this.stfnm = stfnm;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getEntrydt() {
		return entrydt;
	}
	public void setEntrydt(Timestamp entrydt) {
		this.entrydt = entrydt;
	}
	public Timestamp getResigndt() {
		return resigndt;
	}
	public void setResigndt(Timestamp resigndt) {
		this.resigndt = resigndt;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPic_img() {
		return pic_img;
	}
	public void setPic_img(String pic_img) {
		this.pic_img = pic_img;
	}
	public String getPic_img_orn() {
		return pic_img_orn;
	}
	public void setPic_img_orn(String pic_img_orn) {
		this.pic_img_orn = pic_img_orn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdd_detail() {
		return add_detail;
	}
	public void setAdd_detail(String add_detail) {
		this.add_detail = add_detail;
	}
	public Timestamp getRegdt() {
		return regdt;
	}
	public void setRegdt(Timestamp regdt) {
		this.regdt = regdt;
	}
	public String getRegnm() {
		return regnm;
	}
	public void setRegnm(String regnm) {
		this.regnm = regnm;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
	@Override
	public String toString() {
		return "StaffDto [stfid=" + stfid + ", pwd=" + pwd + ", ismgr=" + ismgr + ", stfnm=" + stfnm + ", jumin="
				+ jumin + ", phone=" + phone + ", entrydt=" + entrydt + ", resigndt=" + resigndt + ", salary=" + salary
				+ ", pic_img=" + pic_img + ", pic_img_orn=" + pic_img_orn + ", address=" + address + ", add_detail="
				+ add_detail + ", regdt=" + regdt + ", regnm=" + regnm + ", jobid=" + jobid + ", deptid=" + deptid
				+ "]";
	}

	
}
