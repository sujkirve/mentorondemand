package com.ibm.payments.exception;

public class ApiException extends Exception {

	/**
	*
	*/
	private static final long serialVersionUID = 405089290568657115L;

	private String code;

	private String message;

	public ApiException() {
		this("API_ERROR", "API Error", new Exception());
	}

	public ApiException(String code, String message) {
		this(code, message, new Exception());
	}

	public ApiException(String code, String message, Exception ex) {
		super(message, ex);
		this.code = code;
		this.message = message;
	}

	public ApiException(String code, String message, Throwable ex) {
		this(code, message, new Exception(ex));
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApiException [code=" + code + ", message=" + message + "]";
	}

}
