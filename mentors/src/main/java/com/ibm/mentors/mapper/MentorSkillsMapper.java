package com.ibm.mentors.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.mentors.model.MentorSkills;
import com.ibm.mentors.model.MentorSkillsResponse;

@Component
public class MentorSkillsMapper {

	public List<MentorSkillsResponse> mapMentorSkillsResponse(List<MentorSkills>  mentorSkills) {
		List<MentorSkillsResponse> mentorSkillsList = new ArrayList<>(); 
		for(MentorSkills mentorSkill :mentorSkills) {
			MentorSkillsResponse mentorSkillsResponse = new MentorSkillsResponse();
			mentorSkillsResponse.setMentorId(mentorSkill.getMentor().getId());
			mentorSkillsResponse.setTechnology(mentorSkill.getTechnology().getName());
			mentorSkillsResponse.setYearofExperience(mentorSkill.getYearofExperience());
			mentorSkillsList.add(mentorSkillsResponse);
		}
		return mentorSkillsList;
		
	}
}
