package com.cursospring.restApiProject.exception;

import java.time.LocalDateTime;

public class DetallesError {

	private LocalDateTime momento;
	private String mensaje;
	private String detalles;

	public DetallesError(LocalDateTime momento,String mensaje, String detalles) {
		super();
		this.momento = momento;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}
	
	public LocalDateTime getMomento() {
		return momento;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getDetalles() {
		return detalles;
	}
}
