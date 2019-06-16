package com.ibm.trainings.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.trainings.model.Trainings;
import com.ibm.trainings.model.TrainingDetail;
import com.ibm.trainings.model.TrainingListResponse;

@Component
public class TraningsMapper {

	public TrainingListResponse mapTraningListReponse(List<Trainings> trainings) {

		TrainingListResponse trainingListResponse = new TrainingListResponse();

		List<TrainingDetail> trainingDetails = new ArrayList<TrainingDetail>();

		for (Trainings training : trainings) {
			TrainingDetail trainingDetail = new TrainingDetail();
			trainingDetail.setTrainerId(training.getId());
			trainingDetail.setTrainingStartDate(training.getStart_date());
			trainingDetail.setTrainingEndDate(training.getEnd_date());
			trainingDetail.setMentorName(training.getMentor().getFirstname());
			trainingDetail.setMentorEmail(training.getMentor().getEmail());
			trainingDetail.setTrainigStauts(training.getStatus());
			trainingDetail.setTechnology(training.getTechnology().getName());

			trainingDetails.add(trainingDetail);
		}

		trainingListResponse.setTrainings(trainingDetails);
		return trainingListResponse;

	}
}
