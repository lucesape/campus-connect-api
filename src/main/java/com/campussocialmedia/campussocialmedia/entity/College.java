package com.campussocialmedia.campussocialmedia.entity;

public class College {
	Integer year;
	String branch;
	String collegeName;
	public College(Integer year, String branch, String collegeName) {
		super();
		this.year = year;
		this.branch = branch;
		this.collegeName = collegeName;
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	@Override
	public String toString() {
		return "College [year=" + year + ", branch=" + branch  + ", collegeName=" + collegeName + "]";
	}
	
}
