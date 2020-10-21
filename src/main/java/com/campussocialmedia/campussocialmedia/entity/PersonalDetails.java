package com.campussocialmedia.campussocialmedia.entity;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class PersonalDetails {
	private String homeTown;
	private List<String> talents;
	private List<String> achievements;

	public PersonalDetails(String homeTown, List<String> talents, List<String> achievements) {
		super();
		this.homeTown = homeTown;
		this.talents = talents;
		this.achievements = achievements;
	}

	public PersonalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PersonalDetails [homeTown=" + homeTown + ", talents=" + talents + ", achievements=" + achievements
				+ "]";
	}

	@DynamoDBAttribute
	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	@DynamoDBAttribute
	public List<String> getTalents() {
		return talents;
	}

	public void setTalents(List<String> talents) {
		this.talents = talents;
	}

	@DynamoDBAttribute
	public List<String> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<String> achievements) {
		this.achievements = achievements;
	}

}
