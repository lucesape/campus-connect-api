package com.campussocialmedia.campussocialmedia.entity;

import java.util.List;

public class PersonalDetails {
	private String hometown;
	private List<String> talents;
	private List<String> achievements;
	public PersonalDetails(String hometown, List<String> talents, List<String> achievements) {
		super();
		this.hometown = hometown;
		this.talents = talents;
		this.achievements = achievements;
	}
	public PersonalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PersonalDetails [hometown=" + hometown + ", talents=" + talents + ", achievements=" + achievements
				+ "]";
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public List<String> getTalents() {
		return talents;
	}
	public void setTalents(List<String> talents) {
		this.talents = talents;
	}
	public List<String> getAchievements() {
		return achievements;
	}
	public void setAchievements(List<String> achievements) {
		this.achievements = achievements;
	}
	
}
