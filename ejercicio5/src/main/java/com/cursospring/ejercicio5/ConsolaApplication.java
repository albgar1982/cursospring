package com.cursospring.ejercicio5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cursospring.ejercicio5.juegos.GameRunner;
import com.cursospring.ejercicio5.juegos.Juego;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan //POR DEFECTO, busca componentes para crear Beans en el paquete en el que está y en sus subpaquetes. GameRunner no necesita de esta anotación para crear su Bean, ya que está explícitamente llamado desde la clase de configuración, esta ConsolaApplication.class. Si ponemos una ruta concreta, esta anotación deja de buscar donde está y en sus subpaquetes y busca en la ruta especificada y en los subpaquetes de ésta.
public class ConsolaApplication {

	public static void main(String[] args) {

		try( var contexto = new AnnotationConfigApplicationContext(ConsolaApplication.class) ){
			
			/*
			 * Hemos añadido un método con @PostConstruct que se ejecutará al crearse el Bean. Está tanto en MarioGame como en GameRunner
			 * Si comentamos esta línea de código, veremos que Spring instancia primero MarioGame incluso aunque se llame primero a GameRunner.
			 * Los beans que NO dependen de otros se crean primero, mientras que los que dependen de otros beans se crean después, respetando el orden de sus dependencias.
			 */
			System.out.println("Este Bean " + contexto.getBean(Juego.class) + " es el que tiene el @Primary y por eso se ha tomado su Bean aquí, al solicitar un Bean que implemente a Juego (Spring no sabe cuál coger si no es por el @Primary)." );
			
			GameRunner gameRunner = (GameRunner) contexto.getBean("gameRunner"); 
			/* Spring busca específicamente un componente con este nombre 'gameRunner' y LO ENCUENTRA EN @Component GameRunner. 
			 * Es IMPORTANTÍSIMO que memorices que el bean responde al nombre de la clase con la primera letra en minúscula!!!!!
			 * 
			 * Al barrer esta clase de Configuration Spring ve que tiene que crear un Bean GameRunner, pero para ello ve que necesita uno 
			 * más, su dependencia, Juego. No la encuentra porque @Configuration no busca Beans más allá de la clase en la que esté.
			 * Por eso mismo sí intenta crear el GameRunner Bean, pero no un Juego.
			 * POR ESO, hemos de añadir @ComponentScan, que busca en el paquete en el que está y en sus subpaquetes.
			 */
			gameRunner.run();
		}
	}
}
