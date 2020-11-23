package com.campussocialmedia.campussocialmedia.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class College implements Serializable {
	private static final long serialVersionUID = 4449726365885112352L;
	private String year;
	private String branch;
	private String collegeName;
	
	
	public College() {
		super();
	}
	public College(String year, String branch) {
		super();
		this.year = year;
		this.branch = branch;
	}
	public College(String year, String branch, String collegeName) {
		super();
		this.year = year;
		this.branch = branch;
		this.collegeName = collegeName;
	}
	@DynamoDBAttribute
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@DynamoDBAttribute
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@DynamoDBAttribute
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((collegeName == null) ? 0 : collegeName.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		College other = (College) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (collegeName == null) {
			if (other.collegeName != null)
				return false;
		} else if (!collegeName.equals(other.collegeName))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
}
