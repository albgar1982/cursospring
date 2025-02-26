package com.cursospring.ejercicio18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * En este ejercicio usamos Spring JDBC.
 * JDBC (Java Database Connectivity) es una API de Java que permite conectar aplicaciones Java con
 * bases de datos. Proporciona métodos para enviar consultas SQL, actualizar datos y manejar resultados.
 * 
 * También creamos una base de datos H2, que configuramos en el application.properties y cuyo esquema está incluído en el fichero schema.sql, ubicado en la carpeta de recursos
 * 
 * Sin spring-boot-starter-web en el pom.xml, la aplicación no iniciará el servidor web, por lo que no se podrá usar la consola desde el navegador.
 */
@SpringBootApplication
public class Ejercicio18Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio18Application.class, args);
	}
}
