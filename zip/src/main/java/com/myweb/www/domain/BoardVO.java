package com.myweb.www.domain;

public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String reg_date;
	private int read_cnt;
	private String isde;
	
	public BoardVO () {}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getRead_cnt() {
		return read_cnt;
	}

	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
	}

	public String getIsde() {
		return isde;
	}

	public void setIsde(String isde) {
		this.isde = isde;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", reg_date=" + reg_date + ", read_cnt=" + read_cnt + ", isde=" + isde + "]";
	}
	
}
