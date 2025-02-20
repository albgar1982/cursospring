package com.cursospring.ejercicio13;

import java.util.Arrays;

import com.cursospring.ejercicio13.servicios.BusinessCalculationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/*
 * En este ejercicio vamos a coger una app que hicimos antes y cambiar la anotación
 * @Component, que es genérica, por otras que son especializaciones suyas y que hay que usar para indicar a Spring 
 * qué es específicamente cada componente. Estas son las anotaciones Stereotype, entre las que se encuentran
 * @Service, @Repository y @Controller
 * La anotación @Controller se pone en clases que actúan como "controladores" en una aplicación web.
 * Usarías @Controller en clases que:
	-Manejan solicitudes web como GET, PUT, POST...
	-Interactúan con otros componentes de tu aplicación para procesar solicitudes.
	-Preparan y envían respuestas a los clientes.
 */
@Configuration
@ComponentScan
public class CalculationWithStereotypeApplication {

	public static void main(String[] args) {
		
		try( var contexto = new AnnotationConfigApplicationContext(CalculationWithStereotypeApplication.class)){
			
			Arrays.stream( contexto.getBeanDefinitionNames() )
				.forEach( System.out :: println);
			
			BusinessCalculationService businessCalculationService = contexto.getBean(BusinessCalculationService.class);
			
			System.out.println("El máximo del array es: " + businessCalculationService.findMax());
			
		}
	}
}
