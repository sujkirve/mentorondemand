package com.ibm.mentors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.mentors.model.MentorSkills;


@Repository("mentorSkillsRepository")
public interface MentorSkillsRepository extends JpaRepository<MentorSkills, Integer> {
 
	 
	 @Query(value = "select * from MentorSkills m where m.mentor_id=?1", 
			  nativeQuery = true)
	 List<MentorSkills> findByMentorId(int mentorId);
 
	 @Query(value = "select * from MentorSkills m where m.tech_id=?1", 
			  nativeQuery = true)
	 List<MentorSkills> findByTechId(int techId);
}