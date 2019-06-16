package com.ibm.payments.model;

public class PaymentRequest {

	private int trainingId;
	private int mentorId;
	private int candidateId;
	private double amount;


	/**
	 * @return the trainingId
	 */
	public int getTrainingId() {
		return trainingId;
	}

	/**
	 * @param trainingId the trainingId to set
	 */
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	/**
	 * @return the mentorId
	 */
	public int getMentorId() {
		return mentorId;
	}

	/**
	 * @param mentorId
	 *            the mentorId to set
	 */
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	/**
	 * @return the candidateId
	 */
	public int getCandidateId() {
		return candidateId;
	}

	/**
	 * @param candidateId
	 *            the candidateId to set
	 */
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentRequest [trainingId=" + trainingId + ", mentorId=" + mentorId + ", candidateId=" + candidateId
				+ ", amount=" + amount + "]";
	}

}
