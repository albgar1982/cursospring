package com.cursospring.ejercicio19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cursospring.ejercicio19.entidad.Curso;
import com.cursospring.ejercicio19.jpa.CursoJpaRepositorio;

@Component
public class CursoJpaCommandLinerunner implements CommandLineRunner{

	@Autowired
	private CursoJpaRepositorio cursoJpaRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		cursoJpaRepositorio.crearCurso(new Curso(1,"Curso SQL","Fernando Hermida"));
		cursoJpaRepositorio.crearCurso(new Curso(2,"Curso Java","Alberto Garcia"));
		cursoJpaRepositorio.crearCurso(new Curso(3,"Curso Spring","Ranga Karanam"));
		
		cursoJpaRepositorio.eliminarCursoPorId(2);
		
		System.out.println(cursoJpaRepositorio.encontrarCursoPorId(1));
		
	}

}
