package com.ibm.trainings.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.trainings.constant.TrainingConstant;
import com.ibm.trainings.mapper.TraningsMapper;
import com.ibm.trainings.model.Trainings;
import com.ibm.trainings.model.TrainingListResponse;
import com.ibm.trainings.repository.TrainingRepository;
import com.ibm.trainings.utility.DateUtil;

@Service("trainingService")
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private TrainingRepository trainingRepository;

	@Autowired
	private TraningsMapper traningsMapper;

	@Override
	public TrainingListResponse searchTrainingsByTechnology(LocalDate searchStartDate, LocalDate searchEndDate,
			String technologyId) {

		
		//String startDate = DateUtil.getformattedDateString(searchStartDate, TrainingConstant.SQL_DATE_FORMAT);

		//String endDate = DateUtil.getformattedDateString(searchEndDate, TrainingConstant.SQL_DATE_FORMAT);

		List<Trainings> trainings = trainingRepository.findByTechnologyWithDateRange(searchStartDate.toString(), searchEndDate.toString(), technologyId);

		return traningsMapper.mapTraningListReponse(trainings);

	}

}
