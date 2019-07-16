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
@Table(name = "mentorsusersblockdetails")
public class MentorBlockUsers {

	@Id
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "mentor_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User mentor;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	@Column(name = "isBlocked")
	private boolean isBlocked;

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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the isBlocked
	 */
	public boolean isBlocked() {
		return isBlocked;
	}

	/**
	 * @param isBlocked the isBlocked to set
	 */
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MentorSkills [id=" + id + ", mentor=" + mentor + ", user=" + user + ", isBlocked=" + isBlocked + "]";
	}
	

	
}
