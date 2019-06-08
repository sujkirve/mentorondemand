package com.ibm.trainings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.trainings.model.Trainings;


@Repository("trainingRepository")
public interface TrainingRepository extends JpaRepository<Trainings, Long> {
	
	@Query(value = "select * from Trainings t where t.start_date>=?1 and t.end_date<=?2 and t.tech_id=?3", 
			  nativeQuery = true)
	List<Trainings> findByTechnologyWithDateRange(String searchStartDate, String searchEndDate, String tech_id);
 
}