package com.rsrit.rchat.exceptions;

//@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class ConflictingUserException extends RuntimeException {

	private static final long serialVersionUID = 1209917093467344827L;

	public ConflictingUserException() {
		super();
	}

	public ConflictingUserException(String exceptionCause) {
		super(exceptionCause);
	}

}
