package com.cursospring.ejercicio20.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospring.ejercicio20.entidad.Curso;

public interface CursoJpaInterfaceRepositorio extends JpaRepository<Curso, Long>{ //Se pone primero la entidad con la que trabaja el repositorio
//y luego el tipo de su primary key (siempre una clase, no un primitivo). RECUERDA; si una interfaz extiende otra interfaz, hereda sus métodos 
//sin necesidad de implementarlos. En este caso, métodos como findByID(), save(), etc...
	
	/* Para métodos propios del programador, debemos usar la nomenclatura apropiada en el nombre DEL MÉTODO, 
	* con los nombres correctos de los atributos de la entidad Java
	* Como puedes comprobar en estos métodos, NO es necesario respetar esos nombres en los parámetros. SÍ hay que respetar los TIPOS.
	*/
	List<Curso> findByAutor(String nombreAutor);
	
	List<Curso> findByCurso(String nombreCurso);
}
