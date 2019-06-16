package com.ibm.users.model;

import java.util.ArrayList;
import java.util.List;

public class Response {

	String description;
	List<Error>	 errors= new ArrayList<>();
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the errors
	 */
	public List<Error> getErrors() {
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	
}
