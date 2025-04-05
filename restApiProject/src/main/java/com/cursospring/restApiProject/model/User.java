package com.cursospring.restApiProject.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data //Provee de los getters y setters y el método toString
@AllArgsConstructor //Provee de un constructor con todos los argumentos
public class User {
	
	private Integer id;
	
	@Size(min = 2, message = "El nombre debe tener al menos 2 caracteres") //Validación del tamaño del nombre
	private String name;
	
	@Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual") //Validación de que la fecha de nacimiento sea anterior a la fecha actual
	private LocalDate birthDate;
}
