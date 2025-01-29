package com.cursospring.ejercicio4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.cursospring.ejercicio4.juegos.GameRunner;
import com.cursospring.ejercicio4.juegos.Juego;
import com.cursospring.ejercicio4.juegos.MarioGame;
import com.cursospring.ejercicio4.juegos.PacMan;
import com.cursospring.ejercicio4.juegos.SuperContra;

@Configuration
public class ConfiguracionParaAppDeJuegos  {

	@Bean
	@Primary //Si se solicita un Bean de la clase Juego, se devolverá este POR DEFECTO. Recuerda que Juego es la Interfaz a la que implementan los juegos
	public Juego juego() {
		return new MarioGame();
	}
	
	@Bean
	public Juego juego2() {
		return new SuperContra();
	}
	
	@Bean
	@Qualifier("pacMan")
	public Juego juego3() {
		return new PacMan();
	}
	
	@Bean
	public GameRunner gameRunner(@Qualifier("pacMan")Juego juego) {
		return new GameRunner(juego);
	}
}
