package com.cursospring.ejercicio19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Ejercicio en el que se utiliza Spring JPA.
 * JPA (Jakarta Persistence API) es una especificación, que indica cómo se define una entidad, una columna... 
 * Para usarla necesitas una implementación como Hibernate, EclipseLink, o OpenJPA.
 * En este caso estamos usando la Jakarta Persistence API (puedes verlo en los imports de Curso, por ejemplo) directamente, NO Hibernate.
 * 
 * Brinda acceso a las anotaciones JPA como @Entity, @Repository, o la interfaz JpaRepository.
 */
@SpringBootApplication
public class Ejercicio19Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio19Application.class, args);
	}
}
