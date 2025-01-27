package com.cursospring.ejercicio2;

import com.cursospring.ejercicio2.juego.GameRunner;
import com.cursospring.ejercicio2.juego.MarioGame;
import com.cursospring.ejercicio2.juego.PacMan;
import com.cursospring.ejercicio2.juego.SuperContra;

public class AppJugarJavaBasico {

	public static void main(String[] args) {
		
		//Instanciamos el juego de Mario
		//var ya infiere el tipo al que pertenece la variable al instanciar el objeto
		var marioGame = new MarioGame();
		//Instanciamos el juego de SuperContra
		var superContra = new SuperContra();
		//Instanciamos el juego de PacMan
		var pacMan = new PacMan();
		//Y el cargador de juegos
		GameRunner gameRunner = new GameRunner(marioGame);
		gameRunner.run();
		gameRunner = new GameRunner(superContra);
		gameRunner.run();
		gameRunner = new GameRunner(pacMan);
		gameRunner.run();
		//Cuando le pasamos el juego a GameRunner, lo estamos inyectando (injecting) o cableando (wiring)
		/*
		 * Injecting, en el contexto de la inyección de dependencias (Dependency Injection), se refiere al
		 * proceso de proporcionar los objetos (dependencias) que una clase necesita para funcionar, en lugar
		 * de que la clase misma los cree o gestione. Es una técnica utilizada para reducir el acoplamiento
		 * entre clases, mejorar la flexibilidad y facilitar las pruebas unitarias.
		 * En el siguiente ejercicio ya se empieza a usar Spring para que gestione las instancias por nosotros 
		 * usando Beans.
		 */
	}

}
