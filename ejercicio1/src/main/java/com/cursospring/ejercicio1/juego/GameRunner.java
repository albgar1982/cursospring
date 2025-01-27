package com.cursospring.ejercicio1.juego;

/*
 * Este es un buen ejemplo de Tight Coupling o Acoplamiento Fuerte.
 * El cargador del juego deberá ser cambiado a otro juego tanto en su atributo como en su constructor para cambiar el juego.
 * Esto se debe al acoplamiento fuerte.
 */
public class GameRunner {
	
	MarioGame game;

	public GameRunner(MarioGame marioGame) {
		game = marioGame;
	}

	public void run() {
		//Esto es solo como ejemplo; deberíamos usar log
		System.out.println("Juego actual: " + game);	
		
	}

	
}
