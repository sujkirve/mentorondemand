package com.ibm.mentors.service;

import com.ibm.mentors.model.MentorProfileDetails;
import com.ibm.mentors.model.MentorSearchRequest;
import com.ibm.mentors.model.MentorSearchResponse;

public interface MentorService {

	MentorProfileDetails getMentorDetails(int mentorId);
	
	MentorSearchResponse searchMentorsByTechnology(MentorSearchRequest mentorSearchRequest);
}
