package com.cursospring.ejercicio20.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospring.ejercicio20.entidad.Curso;

public interface CursoJpaInterfaceRepositorio extends JpaRepository<Curso, Long>{ //Se pone primero la entidad con la que trabaja el repositorio y luego el tipo de su primary key (siempre una clase, no un primitivo)
	
	List<Curso> findByAutor(String autor);
	
	List<Curso> findByCurso(String curso);
}
