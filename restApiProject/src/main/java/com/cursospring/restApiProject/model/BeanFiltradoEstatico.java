package com.cursospring.restApiProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties({"edad","direccion"}) //Ignora las propiedades del array cuando se serializa el objeto
public class BeanFiltradoEstatico {

	private String nombre;
	//Anotacion de la libreria Jackson que permite ignorar la propiedad cuando se serializa el objeto                                                          
	@JsonIgnore
	private String contrasena;
	private int edad;
	
	private String direccion;
	private String ciudad;
}

/*
 * Tanto @JsonIgnore como @JsonIgnoreProperties se usan para lo que se conoce como filtrado estático.
 * El primero se aplica a una única propiedad, mientras que el segundo se aplica a un conjunto de propiedades.
 * Ambos van a aplicarse siempre, da igual desde dónde accedamos al Bean.
 * 
 * Existe también el filtrado dinámico, que se ve en el otro controlador y con el otro Bean.
 */
