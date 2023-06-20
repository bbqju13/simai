package com.myweb.www.domain;

public class FileVO {
	private String uuid;
	private String save_dir;
	private String file_name;
	private int file_type;
	private int bno;
	private long file_size;
	private String reg_date;

	public FileVO() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getSave_dir() {
		return save_dir;
	}

	public void setSave_dir(String save_dir) {
		this.save_dir = save_dir;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getFile_type() {
		return file_type;
	}

	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	public String getReg_date() {
		return reg_date;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "FileVO [uuid=" + uuid + ", save_dir=" + save_dir + ", file_name=" + file_name + ", file_type="
				+ file_type + ", bno=" + bno + ", file_size=" + file_size + ", reg_date=" + reg_date + "]";
	}

}
