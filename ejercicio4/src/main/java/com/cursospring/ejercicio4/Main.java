package com.cursospring.ejercicio4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cursospring.ejercicio4.juegos.GameRunner;
import com.cursospring.ejercicio4.juegos.Juego;

/*
 * En este ejercicio, simplemente vamos a usar Spring para crear los juegos, así como el GameRunner. La única novedad es
 * el uso del try con parámetros, que cuando ya no necesita el contexto, lo cierra directamente ( observa que ya no hay close() )
 */
public class Main {

	public static void main(String[] args) {


		try( var contexto = new AnnotationConfigApplicationContext(ConfiguracionParaAppDeJuegos.class) ){
			
			System.out.println("Juego más al " + contexto.getBean("juego2") + " que al " + contexto.getBean("juego"));
			
			System.out.println("El juego por defecto es el " + contexto.getBean(Juego.class));
			
			GameRunner gameRunner = (GameRunner) contexto.getBean("gameRunner");
			gameRunner.run();
		}

	}

}
