package com.rsrit.rchat.exceptions;

public class UserAlreadyExistedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistedException() {
		super();
	}

	public UserAlreadyExistedException(String message) {
		super(message);
	}

}
