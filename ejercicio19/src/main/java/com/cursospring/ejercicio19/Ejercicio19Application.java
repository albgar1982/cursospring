package com.cursospring.ejercicio19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Ejercicio en el que se utiliza Spring JPA.
 * JPA (Java Persistence API) es una especificación. 
 * Para usarla necesitas una implementación como Hibernate, EclipseLink, o OpenJPA.
 * 
 * Brinda acceso a las anotaciones JPA como @Entity, @Repository, o la interfaz JpaRepository.
 */
@SpringBootApplication
public class Ejercicio19Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio19Application.class, args);
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Mantiene la app activa
	}

}
