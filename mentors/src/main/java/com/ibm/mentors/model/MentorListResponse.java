package com.ibm.mentors.model;

import java.util.List;

public class MentorListResponse {

	List<MentorProfileDetails> mentors;

	/**
	 * @return the mentors
	 */
	public List<MentorProfileDetails> getMentors() {
		return mentors;
	}

	/**
	 * @param mentors
	 *            the mentors to set
	 */
	public void setMentors(List<MentorProfileDetails> mentors) {
		this.mentors = mentors;
	}

}
