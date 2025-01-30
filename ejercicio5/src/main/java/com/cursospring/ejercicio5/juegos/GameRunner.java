package com.cursospring.ejercicio5.juegos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class GameRunner {
	
	@PostConstruct
    public void init() {
        System.out.println("GameRunner Bean ha sido inicializado con el juego " + game.getClass().getName());
    }
	
	private Juego game; 

	//Esto es inyección de dependencias (auto-wiring) en el constructor.
	public GameRunner(@Qualifier("SuperContraQualifier")Juego juego) { // O simplemente (@Qualifier("superContra") si la clase no tiene @Qualifier, PRUÉBALO
		game = juego;
	}

	public void run() {
		
		System.out.println("Estamos en la clase " + this.getClass().getName() + ". Juego que Spring inyecta mediante auto-wiring en esta clase: " + game);	
		game.arriba();
		game.abajo();
		game.izquierda();
		game.derecha();
	}

	
}
