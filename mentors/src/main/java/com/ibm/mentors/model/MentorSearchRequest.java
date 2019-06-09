package com.ibm.mentors.model;

import java.time.LocalDate;
import java.util.List;


public class MentorSearchRequest {

	List<Integer> technologies;
	LocalDate searchStartDate;
	LocalDate searchEndDate;
	/**
	 * @return the technologies
	 */
	public List<Integer> getTechnologies() {
		return technologies;
	}
	/**
	 * @param technologies the technologies to set
	 */
	public void setTechnologies(List<Integer> technologies) {
		this.technologies = technologies;
	}
	/**
	 * @return the searchStartDate
	 */
	public LocalDate getSearchStartDate() {
		return searchStartDate;
	}
	/**
	 * @param searchStartDate the searchStartDate to set
	 */
	public void setSearchStartDate(LocalDate searchStartDate) {
		this.searchStartDate = searchStartDate;
	}
	/**
	 * @return the searchEndDate
	 */
	public LocalDate getSearchEndDate() {
		return searchEndDate;
	}
	/**
	 * @param searchEndDate the searchEndDate to set
	 */
	public void setSearchEndDate(LocalDate searchEndDate) {
		this.searchEndDate = searchEndDate;
	}
	
	
}
