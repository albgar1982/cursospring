package com.cursospring.ejercicio10;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class ClaseA{
	
	private ClaseB claseB;

	public ClaseA(ClaseB claseB) {
		super();
		this.claseB = claseB;
		System.out.println("Creado el objeto de ClaseA con sus dependencias inyectadas.");
	}
	
	@PostConstruct //Ejecuta el método en cuanto el Bean está listo para su uso. Si tiene dependencias que inyectar, como en este caso, se ejecutará en cuanto estén inyectadas.
	//Nos puede servir por ejemplo para hacer consultas a la BBDD
	public void inicializar() {
		claseB.metodo();
	}
	
	@PreDestroy //Ejecuta antes de cerrar la app, justo antes de destruir el Bean del container.
	//Nos puede servir por ejemplo para cerrar la conexión a la BBDD
	public void limpiar() {
		System.out.println("///////////////////////////////////////////");
		System.out.println("Cerrando conexión con base de datos......");
	}
}

@Component
class ClaseB{
	
	public void metodo() {
		System.out.println("Lógica usando una dependencia.");
	}
}

@Configuration
@ComponentScan
public class PostPreApplication {

	public static void main(String[] args) {
		
		try( var contexto = new AnnotationConfigApplicationContext(PostPreApplication.class) ){
			
			System.out.println("///////////////////////////////////////////");
			System.out.println("Instancias de Beans guardadas en el Context(singletons):");
			
			Arrays.stream(contexto.getBeanFactory().getSingletonNames())
		      .forEach(System.out::println);
		}
	}
}



/*
 * Orden con inicialización por defecto (EAGER, ansiosa):
 *  Se ejecuta el constructor de ClaseA.
	org.springframework.context.annotation.internalConfigurationAnnotationProcessor
	org.springframework.context.annotation.internalAutowiredAnnotationProcessor
	org.springframework.context.annotation.internalCommonAnnotationProcessor
	org.springframework.context.event.internalEventListenerProcessor
	org.springframework.context.event.internalEventListenerFactory
	lazyApplication
	claseA
	claseB
	
	Observa que se ha instanciado un Bean de ClaseA, pero NO de ClaseB, ya que esta última es Lazy (perezosa) y no se instanciará hasta
	que se llame o necesite explícitamente. Descomenta la línea 39 y verás que se instancia ClaseB y cuándo.
	
	Se ejecuta el constructor de ClaseA.
	org.springframework.context.annotation.internalConfigurationAnnotationProcessor
	org.springframework.context.annotation.internalAutowiredAnnotationProcessor
	org.springframework.context.annotation.internalCommonAnnotationProcessor
	org.springframework.context.event.internalEventListenerProcessor
	org.springframework.context.event.internalEventListenerFactory
	lazyApplication
	claseA
	claseB
	Se ejecuta el constructor de ClaseB.
*/


