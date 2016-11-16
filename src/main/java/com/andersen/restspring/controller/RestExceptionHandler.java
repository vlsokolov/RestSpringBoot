package com.andersen.restspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { EventNotFoundException.class })
	protected ResponseEntity<Object> handleConflict(EventNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { EventBadRequestException.class })
	protected ResponseEntity<Object> handleConflict(EventBadRequestException ex, WebRequest request) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
