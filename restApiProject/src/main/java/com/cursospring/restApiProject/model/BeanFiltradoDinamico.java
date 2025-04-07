package com.cursospring.restApiProject.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonFilter("NombreDelFiltro") //Nombre del filtro que se va a aplicar
public class BeanFiltradoDinamico {

	private String nombre;
	private String contrasena;
	private int edad;
	private String direccion;
	private String ciudad;
}
/*
Creado sólo porque es parte del ejemplo de filtrado dinámico.
Si usáramos el BeanEstatico para hacer filtrado dinámico sobre él, primero se filtrarían las propiedades
estáticas y luego las dinámicas, no se puede escapar de las anotaciones de @JsonIgnoreProperties y @JsonIgnore
 */
