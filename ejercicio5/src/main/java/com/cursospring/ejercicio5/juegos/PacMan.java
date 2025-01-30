package com.cursospring.ejercicio5.juegos;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
//@Primary Si lo ponemos, como MarioGAme ya tiene una, saltaría NoUniqueBeanDefinitionException: No qualifying bean of type 'com.cursospring.ejercicio5.juegos.Juego' available: more than one 'primary' bean found among candidates: [marioGame, pacMan]
public class PacMan implements Juego{

	@PostConstruct
    public void init() {
        System.out.println("PacMan Bean ha sido inicializado");
    }
	
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
