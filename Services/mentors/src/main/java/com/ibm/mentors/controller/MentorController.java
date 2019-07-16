package com.ibm.mentors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.mentors.model.MentorBlockUserResponse;
import com.ibm.mentors.model.MentorProfileDetails;
import com.ibm.mentors.model.MentorSearchRequest;
import com.ibm.mentors.model.MentorSearchResponse;
import com.ibm.mentors.service.MentorService;

@RestController
public class MentorController {

	@Autowired
	private MentorService mentorService;

	@RequestMapping(value = { "/mentors/{mentorId}/profile" }, method = RequestMethod.GET)
	public @ResponseBody MentorProfileDetails getMentorProfile(@PathVariable  int mentorId) {

		return mentorService.getMentorDetails(mentorId);
	}

	@RequestMapping(value = { "/mentors/search" }, method = RequestMethod.POST)
	public @ResponseBody MentorSearchResponse searchMentorsByTechnologies(@RequestBody MentorSearchRequest mentorSearchRequest) {

		//Validate Request
		
		return mentorService.searchMentorsByTechnology(mentorSearchRequest);
	}
	
	@RequestMapping(value = { "/mentors/{mentorId}/users/{userId}/block" }, method = RequestMethod.POST)
	public @ResponseBody MentorBlockUserResponse blockUserForMentor(@PathVariable  int mentorId, @PathVariable  int userId) {

		//Validate Request
		return mentorService.blockUserForMentor(mentorId, userId);
	}

}