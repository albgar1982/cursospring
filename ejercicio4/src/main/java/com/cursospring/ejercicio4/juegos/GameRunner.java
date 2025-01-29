package com.cursospring.ejercicio4.juegos;

public class GameRunner {
	
	private Juego game; 

	public GameRunner(Juego juego) {
		game = juego;
	}

	public void run() {
		
		System.out.println("Juego actual: " + game.getClass().getName());	
		game.arriba();
		game.abajo();
		game.izquierda();
		game.derecha();
	}

	
}
