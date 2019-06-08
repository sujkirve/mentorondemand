package com.ibm.mentors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.mentors.model.MentorProfileDetails;
import com.ibm.mentors.service.MentorService;

@RestController
public class MentorController {

	@Autowired
	private MentorService mentorService;

	@RequestMapping(value = { "/mentors/{mentorId}/profile" }, method = RequestMethod.GET)
	public @ResponseBody MentorProfileDetails getMentorProfile(@PathVariable  int mentorId) {

		return mentorService.getMentorDetails(mentorId);
	}

}