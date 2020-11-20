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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achievements == null) ? 0 : achievements.hashCode());
		result = prime * result + ((homeTown == null) ? 0 : homeTown.hashCode());
		result = prime * result + ((talents == null) ? 0 : talents.hashCode());
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
		PersonalDetails other = (PersonalDetails) obj;
		if (achievements == null) {
			if (other.achievements != null)
				return false;
		} else if (!achievements.equals(other.achievements))
			return false;
		if (homeTown == null) {
			if (other.homeTown != null)
				return false;
		} else if (!homeTown.equals(other.homeTown))
			return false;
		if (talents == null) {
			if (other.talents != null)
				return false;
		} else if (!talents.equals(other.talents))
			return false;
		return true;
	}

}
