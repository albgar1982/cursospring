package com.cursospring.ejercicio4.juegos;

public class MarioGame implements Juego {

	public void arriba() {
		System.out.println("Salta");
	}
	
	public void abajo() {
		System.out.println("Entra en una tubería");
	}
	
	public void izquierda() {
		System.out.println("Ve a la izquierda");
	}
	
	public void derecha() {
		System.out.println("Ve a la derecha");
	}
}
