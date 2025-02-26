package com.cursospring.ejercicio20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cursospring.ejercicio20.entidad.Curso;
import com.cursospring.ejercicio20.jpa.CursoJpaInterfaceRepositorio;

@Component //Para que se cree un Bean en el Spring context
public class CursoJpaCommandLinerunner implements CommandLineRunner{

	@Autowired
	private CursoJpaInterfaceRepositorio cursoJpaInterfaceRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		cursoJpaInterfaceRepositorio.save(new Curso(1,"Curso SQL","Fernando Hermida"));
		cursoJpaInterfaceRepositorio.save(new Curso(2,"Curso Java","Alberto Garcia"));
		cursoJpaInterfaceRepositorio.save(new Curso(3,"Curso Spring","Ranga Karanam"));
		
		System.out.println(cursoJpaInterfaceRepositorio.findAll()); //ESTE NO ESTABA EN EL EJERCICIO ANTERIOR

		cursoJpaInterfaceRepositorio.deleteById(2l); //Hay que poner la l para que sea Long (hacerle el casting)
		
		System.out.println(cursoJpaInterfaceRepositorio.findById(1l)); //Hay que poner la l para que sea Long (hacerle el casting)
		

		//Hasta aquí son métodos que da JPA de por sí
		
		System.out.println("/////////////////////////////////////////////////////////////////////////");
		
		//Desde aquí, son métodos que creamos aprovechando la implementación de JpaRepository
		System.out.println(cursoJpaInterfaceRepositorio.findByAutor(""));
		System.out.println(cursoJpaInterfaceRepositorio.findByAutor("Fernando Hermida"));
		
		System.out.println(cursoJpaInterfaceRepositorio.findByCurso("Curso Spring"));

	}

}
