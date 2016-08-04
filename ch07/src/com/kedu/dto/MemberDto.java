package com.kedu.dto;

public class MemberDto {
	private String name;
	private String userid;
	
	public MemberDto() {
	}
	public MemberDto(String name, String userid) {
		this.name = name;
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "MemberDto [name=" + this.name + ", userid = " + this.userid + "]";
	}
}