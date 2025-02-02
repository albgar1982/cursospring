package com.cursospring.ejercicio8;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClaseA{
	
	public ClaseA() {
		System.out.println("Se ejecuta el constructor de ClaseA.");
	}
}

@Component
@Lazy
class ClaseB{
	
	public ClaseB() {
		System.out.println("Se ejecuta el constructor de ClaseB.");
	}
}

@Configuration
@ComponentScan
public class LazyApplication {

	public static void main(String[] args) {
		
		try( var contexto = new AnnotationConfigApplicationContext(LazyApplication.class) ){
			
			Arrays.stream( contexto.getBeanDefinitionNames() )
			.forEach( System.out :: println);
			
			//contexto.getBean(ClaseB.class);
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
	
	Observa que se ha instanciado un Bean de ClaseA, pero NO de ClaseB, ya que esta última es Lazy y no se instanciará hasta
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


