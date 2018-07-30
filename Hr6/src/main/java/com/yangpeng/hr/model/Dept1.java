package com.yangpeng.hr.model;

import java.util.List;

public class Dept1 {
	int id;
	String title;
	String loc;
	
	List<Staff1> staffList;
	public int getId() {
		return id;
	}
	public List<Staff1> getStaffList() {
		return staffList;
	}
	public void setStaffList(List<Staff1> staffList) {
		this.staffList = staffList;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	

}
