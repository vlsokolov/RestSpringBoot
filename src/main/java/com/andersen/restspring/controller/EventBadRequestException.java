package com.andersen.restspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 2703166559413772420L;

}
