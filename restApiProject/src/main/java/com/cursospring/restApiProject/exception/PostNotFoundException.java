package com.cursospring.restApiProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus( code = HttpStatus.NOT_FOUND) //Devuelve un 404 Not Found
public class PostNotFoundException extends RuntimeException { 

	public PostNotFoundException(String message) {
		super(message);
	}
}