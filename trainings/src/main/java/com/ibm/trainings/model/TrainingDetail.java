package com.ibm.trainings.model;

import java.util.Date;

public class TrainingDetail {

	int trainerId;
	String mentorName;
	String mentorEmail;
	String technology;
	Date trainingStartDate;
	Date trainingEndDate;
	String trainigStauts;

	
	/**
	 * @return the trainerId
	 */
	public int getTrainerId() {
		return trainerId;
	}
	/**
	 * @param trainerId the trainerId to set
	 */
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	/**
	 * @return the mentorName
	 */
	public String getMentorName() {
		return mentorName;
	}
	/**
	 * @param mentorName the mentorName to set
	 */
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	/**
	 * @return the mentorEmail
	 */
	public String getMentorEmail() {
		return mentorEmail;
	}
	/**
	 * @param mentorEmail the mentorEmail to set
	 */
	public void setMentorEmail(String mentorEmail) {
		this.mentorEmail = mentorEmail;
	}
	/**
	 * @return the trainingStartDate
	 */
	public Date getTrainingStartDate() {
		return trainingStartDate;
	}
	/**
	 * @param trainingStartDate the trainingStartDate to set
	 */
	public void setTrainingStartDate(Date trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}
	/**
	 * @return the trainingEndDate
	 */
	public Date getTrainingEndDate() {
		return trainingEndDate;
	}
	/**
	 * @param trainingEndDate the trainingEndDate to set
	 */
	public void setTrainingEndDate(Date trainingEndDate) {
		this.trainingEndDate = trainingEndDate;
	}
	/**
	 * @return the trainigStauts
	 */
	public String getTrainigStauts() {
		return trainigStauts;
	}
	/**
	 * @param trainigStauts the trainigStauts to set
	 */
	public void setTrainigStauts(String trainigStauts) {
		this.trainigStauts = trainigStauts;
	}
	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	
	
}
