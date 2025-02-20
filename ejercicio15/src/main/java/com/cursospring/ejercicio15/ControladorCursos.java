package com.cursospring.ejercicio15;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ControladorCursos {

	/*
	 * http://localhost:8080/cursos
	 */
	@RequestMapping("/cursos")
	public List<Curso> devuelveTodosLosCursos() {
		return Arrays.asList( 
				new Curso(1, "Aprende Java","Alberto Garcia")
				,new Curso(2, "Aprende Spring","Alberto Garcia")
				,new Curso(3, "Aprende a conducir","Alberto Garcia") );
	}
}
