package com.kedu.notice.dto;

import java.sql.Timestamp;

public class NoticeDto {
	private String stfid;
	private int noticeno;
	private String noticetitle;
	private String regdt;
	private int readcount;
	private String contents;
	private int deptid;
	private String stfnm;
	private String deptnm;
	
	
	public String getDeptnm() {
		return deptnm;
	}

	public void setDeptnm(String deptnm) {
		this.deptnm = deptnm;
	}

	public String getStfnm() {
		return stfnm;
	}

	public void setStfnm(String stfnm) {
		this.stfnm = stfnm;
	}

	public String getStfid() {
		return stfid;
	}

	public void setStfid(String stfid) {
		this.stfid = stfid;
	}

	public int getNoticeno() {
		return noticeno;
	}

	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}


	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getNoticetitle() {
		return noticetitle;
	}

	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}


	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}


}
