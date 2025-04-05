package com.cursospring.restApiProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //Ya que queremos un constructor con todos los campos y el que genera Data no lo incluye
public class MensajeBean {

	private String mensaje;
}
