package com.ibm.mentors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.mentors.model.MentorDetails;


@Repository("mentorRepository")
public interface MentorRepository extends JpaRepository<MentorDetails, Integer> {
 
	MentorDetails findByMentorId(Integer mentorId);
 
}