package com.cursospring.ejercicio2.juego;

/*
 * Ahora tenemos un acoplamiento menor gracias a la creación de una interfaz (Juego) que
 * implementan los 2 juegos. 
 * Si no hubiéramos hecho esto, para usar otro juego habríamos tenido que cambiar el atributo 
 * en GameRunner a SuperContra, así como su constructor.
 */
public class GameRunner {
	
	private Juego game; //game es una dependencia de GameRunner, ya que GameRunner necesita un Juego

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
