package com.kedu.reply.dto;

public class ReplyeDto {
	private int replyno;
	private int noticeno;
	private String stfid;
	private String regdt;
	private String contents;
	public int getReplyno() {
		return replyno;
	}
	public void setReplyno(int replyno) {
		this.replyno = replyno;
	}
	public int getNoticeno() {
		return noticeno;
	}
	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}
	public String getStfid() {
		return stfid;
	}
	public void setStfid(String stfid) {
		this.stfid = stfid;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}
