package com.ibm.mentors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.mentors.model.MentorDetails;
import com.ibm.mentors.model.MentorProfileDetails;
import com.ibm.mentors.model.MentorSkills;
import com.ibm.mentors.repository.MentorRepository;
import com.ibm.mentors.repository.MentorSkillsRepository;
import com.ibm.mentors.repository.UserRepository;

@Service("userService")
public class MentorServiceImpl implements MentorService {

	@Autowired
	private MentorRepository mentorRepository;

	@Autowired
	private MentorSkillsRepository mentorSkillsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public MentorProfileDetails getMentorDetails(int mentorId) {
		
		MentorProfileDetails mentorProfileDetails = new MentorProfileDetails();
		MentorDetails  mentorDetails = mentorRepository.findByMentorId(mentorId);
		
		List<MentorSkills>  mentorSkills = mentorSkillsRepository.findByMentorId(mentorId);
		
		if(mentorDetails!=null) {
			mentorProfileDetails.setExpertise(mentorDetails.getExpertise());
			mentorProfileDetails.setYearOfExp(mentorDetails.getExperience());
			mentorProfileDetails.setMentorSkills(mentorSkills);
		}
		
		return mentorProfileDetails;
	}

}
