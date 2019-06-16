package com.ibm.trainings.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.trainings.model.TrainingListResponse;
import com.ibm.trainings.service.TrainingService;
import com.ibm.trainings.utility.TrainingsValidator;

@RestController
public class TrainingsController {

	@Autowired
	private TrainingService trainingService;

	@RequestMapping(value = { "/technologies/{technologyId}/trainings" }, method = RequestMethod.GET)
	public @ResponseBody TrainingListResponse searchTrainingsByTechnology(@PathVariable String technologyId,
			@RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate searchStartDate,
			@RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate searchEndDate)
			throws Exception {

		TrainingsValidator.dateValidation(searchStartDate, searchEndDate);
		return trainingService.searchTrainingsByTechnology(searchStartDate, searchEndDate, technologyId);
	}

}