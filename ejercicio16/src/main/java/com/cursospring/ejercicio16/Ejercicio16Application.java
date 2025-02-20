package com.cursospring.ejercicio16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * En este ejercicio vamos a cambiar la configuración usando distintos perfiles. 
 * En el application properties ponemos el nivel del log en trace (enseña TODOS los logs que genera Spring; mira los apuntes).
 * En producción no queremos tanto log, queremos el mínimo para no gastar memoria, así que lo queremos poner en info.
 * Los nombres de los application properties siempre han de ser application-nombreEntorno.properties
 * para luego poner en el application.properties la propiedad spring.profiles.active=nombreEntorno 
 * Esto va a indicar que, para las propiedades no especificadas en el segundo properties, se usarán las del application.properties
 * y, para las que coincidan, se usará lo definido en el application-nombreEntorno.properties , ignorando lo configurado en el 
 * primero.
 * CUIDADO! Si ponemos un nombre de profile que no existe, la app correrá con ese profile, pero NO cargará ningún properties distinto del 
 * application.properties original. Puedes probarlo borrando alguna letra en ese nombre.
 */ 
@SpringBootApplication
public class Ejercicio16Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio16Application.class, args);
	}

}
