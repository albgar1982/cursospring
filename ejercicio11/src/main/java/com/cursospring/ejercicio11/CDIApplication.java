package com.cursospring.ejercicio11;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named //Es lo mismo pero en CDI en vez de Spring
class ServicioDeNegocio{
	
	private ServicioDeDatos servicioDeDatos;

	public ServicioDeDatos getServicioDeDatos() {
		return servicioDeDatos;
	}

	//@Autowired
	@Inject //Es lo mismo pero en CDI en vez de Spring
	public void setServicioDeDatos(ServicioDeDatos servicioDeDatos) {
		System.out.println("Inyectado servicioDeDatos en el setter.");
		this.servicioDeDatos = servicioDeDatos;
	}
}

@Named
class ServicioDeDatos{

}

@Configuration
@ComponentScan
public class CDIApplication {

	public static void main(String[] args) {
		
		try( var contexto = new AnnotationConfigApplicationContext(CDIApplication.class) ){
			
			System.out.println("Definiciones de Beans guardadas en el Spring Context:");
			
			Arrays.stream(contexto.getBeanDefinitionNames())
		      .forEach(System.out::println);
		}
	}
}
