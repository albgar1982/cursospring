package com.cursospring.ejercicio18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * Clase que implementa CommandLineRunner para que se 
 * ejecute su método run() al acabar el arranque de la aplicación.
 */
@Component //Así lo cargará Spring directamente en el arranque
public class CursoJdbcCommandLineRunner implements CommandLineRunner{ //Hay que implementar su método run()

	@Autowired //Inyectamos el repositorio, para poder acceder a sus métodos desde esta clase.
	private CursoJdbcRepositorio cursoJdbcRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		cursoJdbcRepositorio.insert(new Curso(1,"Curso SQL","Fernando Hermida"));
		cursoJdbcRepositorio.insert(new Curso(2,"Curso Java","Alberto Garcia"));
		cursoJdbcRepositorio.insert(new Curso(3,"Curso Spring","Ranga Karanam"));
		
		cursoJdbcRepositorio.delete(2);
		
		System.out.println(cursoJdbcRepositorio.select(1));
	}
}
