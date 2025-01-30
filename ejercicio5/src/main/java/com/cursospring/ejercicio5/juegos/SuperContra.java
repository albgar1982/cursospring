package com.cursospring.ejercicio5.juegos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Qualifier("SuperContraQualifier")
public class SuperContra implements Juego{

	@PostConstruct
    public void init() {
        System.out.println("SuperContra Bean ha sido inicializado");
    }
	
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
