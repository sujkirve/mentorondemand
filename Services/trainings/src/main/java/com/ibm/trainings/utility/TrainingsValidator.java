package com.ibm.trainings.utility;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ibm.trainings.constant.TrainingConstant;

@Component
public class TrainingsValidator {

	
	public static void dateValidation(LocalDate searchStartDate, LocalDate searchEndDate)
			throws Exception {
		if (null != searchStartDate && null != searchEndDate && searchStartDate.isAfter(searchEndDate)) {
			throw new Exception(TrainingConstant.API_ERROR_MSG_SEARCH_START_END_DATE_ERROR);
		}

	}
	
}
