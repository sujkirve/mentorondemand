package com.ibm.trainings.model;

import java.util.List;

public class TrainingListResponse {

	List<TrainingDetail> trainings;

	/**
	 * @return the trainings
	 */
	public List<TrainingDetail> getTrainings() {
		return trainings;
	}

	/**
	 * @param trainings the trainings to set
	 */
	public void setTrainings(List<TrainingDetail> trainings) {
		this.trainings = trainings;
	}
	
	
}
