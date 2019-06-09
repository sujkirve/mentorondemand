package com.ibm.mentors.model;

public class MentorSkillsResponse {

	int mentorId;
	String technology;
	double yearofExperience;
	/**
	 * @return the mentorId
	 */
	public int getMentorId() {
		return mentorId;
	}
	/**
	 * @param mentorId the mentorId to set
	 */
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	/**
	 * @return the yearofExperience
	 */
	public double getYearofExperience() {
		return yearofExperience;
	}
	/**
	 * @param yearofExperience the yearofExperience to set
	 */
	public void setYearofExperience(double yearofExperience) {
		this.yearofExperience = yearofExperience;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MentorSkillsResponse [mentorId=" + mentorId + ", technology=" + technology + ", yearofExperience="
				+ yearofExperience + "]";
	}
	
	
}
