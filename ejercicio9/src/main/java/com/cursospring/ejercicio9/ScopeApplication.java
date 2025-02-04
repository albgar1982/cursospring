package com.cursospring.ejercicio9;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class ClaseA{}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ClaseB{}

@Configuration
@ComponentScan
public class ScopeApplication {

	public static void main(String[] args) {
		
		try( var contexto = new AnnotationConfigApplicationContext(ScopeApplication.class) ){
			
			//Lista los nombres de los "candidatos" a bean, es decir, aquellos que están definidos en el contexto, pero no significa que ya hayan sido instanciados.
			Arrays.stream( contexto.getBeanDefinitionNames() )
			.forEach( System.out :: println);
			
			System.out.println("///////////////////////////////////////////");

			//Para listar los beans que realmente han sido instanciados y almacenados en el contexto, usa:
			System.out.println("Instancias de Beans guardadas en el Context:");
			Arrays.stream(contexto.getBeanFactory().getSingletonNames())
		      .forEach(System.out::println); //NOTA que de ClaseA ya se ha creado un Bean 
			
			System.out.println("///////////////////////////////////////////");
			
			//Si no ponemos nada, por defecto la clase será singleton, cada vez que se llame se recurrirá a la misma instancia, que se almacena en el IoC container.
			
			System.out.println("Referencias en memoria de las clases singleton:");
			System.out.println(contexto.getBean(ClaseA.class));
			System.out.println(contexto.getBean(ClaseA.class));
			System.out.println(contexto.getBean(ClaseA.class));
			
			System.out.println("///////////////////////////////////////////");
			
			//Con @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE), cada llamada al objeto crea una nueva instancia de la clase.
			//Estas instancias NO se guardan en el Spring Context!!!!!!!!!! De hecho, el Garbage Collector las eliminará del JVM cuando vea que no se usan.
			System.out.println("Referencias en memoria de las clases prototype:");
			System.out.println(contexto.getBean(ClaseB.class));
			System.out.println(contexto.getBean(ClaseB.class));
			System.out.println(contexto.getBean(ClaseB.class));
			
			System.out.println("///////////////////////////////////////////");

			System.out.println("Instancias de Beans guardadas en el Context:");
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


