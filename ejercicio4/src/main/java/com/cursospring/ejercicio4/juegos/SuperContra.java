package com.cursospring.ejercicio4.juegos;

public class SuperContra implements Juego{

	@Override
	public void arriba() {
		System.out.println("Arriba");	
	}

	@Override
	public void abajo() {
		System.out.println("Sentarse");		
	}

	@Override
	public void izquierda() {
		System.out.println("Ir atrás");
	}

	@Override
	public void derecha() {
		System.out.println("Pegar un tiro");
	}
}
