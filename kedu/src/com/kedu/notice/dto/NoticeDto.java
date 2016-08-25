package com.kedu.notice.dto;


public class NoticeDto {
	private int noticeid;
	private String noticetitle;
	private String regdt;
	private int readcount;
	private String comment;

	public int getNoticeid() {
		return noticeid;
	}

	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}

	public String getNoticetitle() {
		return noticetitle;
	}

	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}

	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
