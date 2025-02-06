package com.cursospring.ejercicio12.juego;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	private MarioGame mario;

	public GameRunner(MarioGame marioGame) {
		mario = marioGame;
	}

	public void run() {
		System.out.println("Juego actual: " + mario.getClass().getName());
		mario.arriba();
		mario.abajo();
		mario.izquierda();
		mario.derecha();
	}
}
