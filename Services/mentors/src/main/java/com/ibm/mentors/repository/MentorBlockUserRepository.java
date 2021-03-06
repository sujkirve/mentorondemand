package com.ibm.mentors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.mentors.model.MentorBlockUserResponse;
import com.ibm.mentors.model.MentorBlockUsers;
import com.ibm.mentors.model.MentorSkills;


@Repository("mentorSkillsRepository")
public interface MentorBlockUserRepository extends JpaRepository<MentorBlockUsers, Integer> {
 
	 
	 @Query(value = "select * from MentorSkills m where m.mentor_id=?1", 
			  nativeQuery = true)
	 List<MentorSkills> addmentor(int mentorId);
 
	 @Query(value = "select * from MentorSkills m where m.tech_id=?1", 
			  nativeQuery = true)
	 List<MentorSkills> findByTechId(int techId);
}