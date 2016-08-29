package com.kedu.project.dto;

public class ProjectDto {
	private int pjtid;
	private String pjtnm;
	private String site;
	private String startdt;
	private String enddt;
	private String contents;
	
	public int getPjtid() {
		return pjtid;
	}
	public void setPjtid(int pjtid) {
		this.pjtid = pjtid;
	}
	public String getPjtnm() {
		return pjtnm;
	}
	public void setPjtnm(String pjtnm) {
		this.pjtnm = pjtnm;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getStartdt() {
		return startdt;
	}
	public void setStartdt(String startdt) {
		this.startdt = startdt;
	}
	public String getEnddt() {
		return enddt;
	}
	public void setEnddt(String enddt) {
		this.enddt = enddt;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
}
