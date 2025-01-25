package com.cursospring.ejercicio1.juego;

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
