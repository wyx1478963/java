package com.model;

public class Course {
	private int cid;
	private String cname;
	private int tid;
	
	public Course(int cid, String cname, int tid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.tid = tid;
	}
	public Course() {
		super();
	}
	public Course(String name) {
		super();
		this.cname=name;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
}
