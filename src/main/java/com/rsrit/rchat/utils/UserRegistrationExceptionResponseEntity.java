package com.rsrit.rchat.utils;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rsrit.rchat.exceptions.ConflictingUserException;

@ControllerAdvice
@RestController
public class UserRegistrationExceptionResponseEntity extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConflictingUserException.class)
	public final ResponseEntity<ErrorDetails> handleConflictingUserException(ConflictingUserException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
	}

}
