package com.ibm.mentors.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "mentorskills")
public class MentorSkills {

	@Id
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "mentor_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User mentor;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "tech_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Technology technology;
	
	@Column(name = "experience")
	private double yearofExperience;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the mentor
	 */
	public User getMentor() {
		return mentor;
	}

	/**
	 * @param mentor the mentor to set
	 */
	public void setMentor(User mentor) {
		this.mentor = mentor;
	}

	/**
	 * @return the technology
	 */
	public Technology getTechnology() {
		return technology;
	}

	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	/**
	 * @return the yearofExperience
	 */
	public double getYearofExperience() {
		return yearofExperience;
	}

	/**
	 * @param yearofExperience the yearofExperience to set
	 */
	public void setYearofExperience(double yearofExperience) {
		this.yearofExperience = yearofExperience;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MentorSkills [id=" + id + ", mentor=" + mentor + ", technology=" + technology + ", yearofExperience="
				+ yearofExperience + "]";
	}
	
	
}
