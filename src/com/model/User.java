package com.model;

public class User {
	private String userName;
	private String psd;
	private int type;
	public User(String userName, String psd, int type) {
		super();
		this.userName = userName;
		this.psd = psd;
		this.type = type;
	}
	public User(String userName, String psd) {
		super();
		this.userName = userName;
		this.psd = psd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}	
}
