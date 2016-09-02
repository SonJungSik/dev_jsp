package com.kedu.skill.dto;

public class SkillDto {
	private int skillno;
	private String skilltitle;
	private String pjtid;
	private String[] skill;
	
	
	public String[] getSkill() {
		return skill;
	}
	public void setSkill(String[] skill) {
		this.skill = skill;
	}
	public String getPjtid() {
		return pjtid;
	}
	public void setPjtid(String pjtid) {
		this.pjtid = pjtid;
	}
	public int getSkillno() {
		return skillno;
	}
	public void setSkillno(int skillno) {
		this.skillno = skillno;
	}
	
	public String getSkilltitle() {
		return skilltitle;
	}
	
	public void setSkilltitle(String skilltitle) {
		this.skilltitle = skilltitle;
	}
	
	
	
}
