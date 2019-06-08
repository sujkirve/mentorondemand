package com.ibm.mentors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.mentors.model.MentorSkills;


@Repository("mentorSkillsRepository")
public interface MentorSkillsRepository extends JpaRepository<MentorSkills, Integer> {
 
	 List<MentorSkills> findByMentorId(int mentorId);
 
}