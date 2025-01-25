package com.cursospring.ejercicio1;

import com.cursospring.ejercicio1.juego.GameRunner;
import com.cursospring.ejercicio1.juego.MarioGame;

public class AppJugarJavaBasico {

	public static void main(String[] args) {
		
		//Instanciamos el juego de Mario
		MarioGame marioGame = new MarioGame();
		//Y el cargador de juegos
		GameRunner gameRunner = new GameRunner(marioGame);
		gameRunner.run();

	}

}
