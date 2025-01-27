package com.cursospring.ejercicio2.juego;

public class PacMan implements Juego{

	@Override
	public void arriba() {
		System.out.println("Up");
		
	}

	@Override
	public void abajo() {
		System.out.println("Down");		
	}

	@Override
	public void izquierda() {
		System.out.println("Left");		
	}

	@Override
	public void derecha() {
		System.out.println("Right");		
	}

}
