package com.ibm.trainings.service;

import java.time.LocalDate;

import com.ibm.trainings.model.TrainingListResponse;

public interface TrainingService {


	TrainingListResponse searchTrainingsByTechnology(LocalDate startDate, LocalDate endDate, String technologyId);
}
