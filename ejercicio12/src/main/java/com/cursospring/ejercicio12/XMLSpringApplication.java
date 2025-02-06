package com.cursospring.ejercicio12;

import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cursospring.ejercicio12.juego.GameRunner;

/*
 * En este ejercicio vamos a crear un contexto a través de un XML de configuración, 
 * el /ejercicio12/src/main/resources/contextConfiguration.xml.
 * También hemos añadido sendos xml para el contexto y los beans en la ruta 
 * /ejercicio12/src/main/resources/schemas para no tener que leerlos online desde el repositorio de Spring
 */
public class XMLSpringApplication {

	public static void main(String[] args) {
		
		try( var contexto = new ClassPathXmlApplicationContext("contextConfiguration.xml") ){
			
			System.out.println("Definiciones de Beans guardadas en el Spring Context:");
			
			Arrays.stream(contexto.getBeanDefinitionNames())
		      .forEach(System.out::println);
			
			System.out.println(contexto.getBean("nombre"));
			System.out.println(contexto.getBean("edad"));
			
			contexto.getBean(GameRunner.class).run();
			
		}
	}
}
