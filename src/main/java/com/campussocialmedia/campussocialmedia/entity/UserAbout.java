package com.campussocialmedia.campussocialmedia.entity;

import java.util.HashMap;
import java.util.List;

public class UserAbout {
	// private String userId;
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	private List<Experience> experiences;
	private List<Fishpond> fishponds;
	private College collegeDetails;
	private PersonalDetails personalDetails;
	private String bio;
	private String intro;
	private HashMap<String, String> socialLinks;
	private String profilePhotoURL;

	public UserAbout() {
		super();
	}

	public UserAbout(String userName) {
		super();
		this.userName = userName;
	}

	public UserAbout(String userName, String email, String password, String firstName, String lastName,
			College collegeDetails) {
		super();
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.collegeDetails = collegeDetails;
	}

	public UserAbout(String userName, String firstName, String lastName, College collegeDetails,
			PersonalDetails personalDetails, String bio, String intro) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.collegeDetails = collegeDetails;
		this.personalDetails = personalDetails;
		this.bio = bio;
		this.intro = intro;
	}

	public UserAbout(String userName, String email, String firstName, String lastName, String phone,
			List<Long> followers, List<Long> following, List<Experience> experiences, List<Long> posts,
			List<Fishpond> fishponds, College collegeDetails, PersonalDetails personalDetails, String bio, String intro,
			HashMap<String, String> socialLinks, String profilePhotoURL) {
		super();
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.experiences = experiences;
		this.fishponds = fishponds;
		this.collegeDetails = collegeDetails;
		this.personalDetails = personalDetails;
		this.bio = bio;
		this.intro = intro;
		this.socialLinks = socialLinks;
		this.profilePhotoURL = profilePhotoURL;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Fishpond> getFishponds() {
		return fishponds;
	}

	public void setFishponds(List<Fishpond> fishponds) {
		this.fishponds = fishponds;
	}

	public HashMap<String, String> getSocialLinks() {
		return socialLinks;
	}

	public void setSocialLinks(HashMap<String, String> socialLinks) {
		this.socialLinks = socialLinks;
	}

	public College getCollegeDetails() {
		return collegeDetails;
	}

	public void setCollegeDetails(College collegeDetails) {
		this.collegeDetails = collegeDetails;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getProfilePhotoURL() {
		return profilePhotoURL;
	}

	public void setProfilePhotoURL(String profilePhotoURL) {
		this.profilePhotoURL = profilePhotoURL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((collegeDetails == null) ? 0 : collegeDetails.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((experiences == null) ? 0 : experiences.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fishponds == null) ? 0 : fishponds.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((personalDetails == null) ? 0 : personalDetails.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((profilePhotoURL == null) ? 0 : profilePhotoURL.hashCode());
		result = prime * result + ((socialLinks == null) ? 0 : socialLinks.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		UserAbout other = (UserAbout) obj;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (collegeDetails == null) {
			if (other.collegeDetails != null)
				return false;
		} else if (!collegeDetails.equals(other.collegeDetails))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (experiences == null) {
			if (other.experiences != null)
				return false;
		} else if (!experiences.equals(other.experiences))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (fishponds == null) {
			if (other.fishponds != null)
				return false;
		} else if (!fishponds.equals(other.fishponds))
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (personalDetails == null) {
			if (other.personalDetails != null)
				return false;
		} else if (!personalDetails.equals(other.personalDetails))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (profilePhotoURL == null) {
			if (other.profilePhotoURL != null)
				return false;
		} else if (!profilePhotoURL.equals(other.profilePhotoURL))
			return false;
		if (socialLinks == null) {
			if (other.socialLinks != null)
				return false;
		} else if (!socialLinks.equals(other.socialLinks))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAbout [userName=" + userName + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phone=" + phone + ", experiences=" + experiences + ", fishponds=" + fishponds
				+ ", collegeDetails=" + collegeDetails + ", personalDetails=" + personalDetails + ", bio=" + bio
				+ ", intro=" + intro + ", socialLinks=" + socialLinks + ", profilePhotoURL=" + profilePhotoURL + "]";
	}

}
