package com.cursospring.ejercicio20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Ejercicio muy similar al anterior, pero en el que vamos a extender el JpaRepository
 * para hacer uso de los métodos predefinidos de los que provee.
 * 
 * Además, simplificamos todo lo posible, haciendo coincidir nombres de entidad y tabla, atributos y columnas, nombre de URL de BD...
 */
@SpringBootApplication
public class Ejercicio20Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio20Application.class, args);
	}

}
