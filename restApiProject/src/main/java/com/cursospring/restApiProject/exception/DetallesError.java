package com.cursospring.restApiProject.exception;

import java.time.LocalDateTime;

public class DetallesError {

	private LocalDateTime timeStamp; //Momento en el que se produce el error
	private String message; //Mensaje de error
	private String details; //Detalles del error

	public DetallesError(LocalDateTime timeStamp,String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	
	public LocalDateTime getTimeStamp() {
		return timeStamp; //Momento en el que se produce el error;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
