package com.ibm.mentors.model;

import java.util.List;

public class MentorProfileDetails {

	String mentorId;
	String mentorName;
	String mentorEmail;
	List<MentorSkills> mentorSkills;
	String expertise;
	Double yearOfExp;

	/**
	 * @return the mentorId
	 */
	public String getMentorId() {
		return mentorId;
	}

	/**
	 * @param mentorId
	 *            the mentorId to set
	 */
	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}

	/**
	 * @return the mentorName
	 */
	public String getMentorName() {
		return mentorName;
	}

	/**
	 * @param mentorName
	 *            the mentorName to set
	 */
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	/**
	 * @return the mentorEmail
	 */
	public String getMentorEmail() {
		return mentorEmail;
	}

	/**
	 * @param mentorEmail
	 *            the mentorEmail to set
	 */
	public void setMentorEmail(String mentorEmail) {
		this.mentorEmail = mentorEmail;
	}

	/**
	 * @return the mentorSkills
	 */
	public List<MentorSkills> getMentorSkills() {
		return mentorSkills;
	}

	/**
	 * @param mentorSkills
	 *            the mentorSkills to set
	 */
	public void setMentorSkills(List<MentorSkills> mentorSkills) {
		this.mentorSkills = mentorSkills;
	}

	/**
	 * @return the expertise
	 */
	public String getExpertise() {
		return expertise;
	}

	/**
	 * @param expertise
	 *            the expertise to set
	 */
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	/**
	 * @return the yearOfExp
	 */
	public Double getYearOfExp() {
		return yearOfExp;
	}

	/**
	 * @param yearOfExp
	 *            the yearOfExp to set
	 */
	public void setYearOfExp(Double yearOfExp) {
		this.yearOfExp = yearOfExp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MentorProfileDetails [mentorId=" + mentorId + ", mentorName=" + mentorName + ", mentorEmail="
				+ mentorEmail + ", mentorSkills=" + mentorSkills + ", expertise=" + expertise + ", yearOfExp="
				+ yearOfExp + "]";
	}

}
