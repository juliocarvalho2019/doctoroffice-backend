package com.julio.doctoroffice.services.exceptions;

public class DataIntegrityVioalationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegrityVioalationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityVioalationException(String message) {
		super(message);
	}
	
	

}
