package com.cursospring.ejercicio5.juegos;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

/*
 * @Component va a crear el Bean en tiempo de ejecución para que esté disponible en el Spring Container, sin haber tenido 
 * que crear un Bean nosotros. El GameRunner de la Configuration que hemos puesto en la clase Main necesita la dependencia Juego,
 * que Spring auto inyectará allí (auto-wiring). Si no le indicamos dónde está este componente con @ComponentScan, saltará
 * NoSuchBeanDefinitionException: No qualifying bean of type 'com.cursospring.ejercicio5.juegos.Juego' available: expected 
 * at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
 * 
 * Si le ponemos está anotación a un segundo Juego, saltará una excepción porque Spring no sabrá cuál de ellos hay que inyectarle a GameRunner
 * UnsatisfiedDependencyException: Error creating bean with name 'gameRunner' defined in com.cursospring.ejercicio5.Main: Unsatisfied 
 * dependency expressed through method 'gameRunner' parameter 0: No qualifying bean of type 'com.cursospring.ejercicio5.juegos.Juego' available:
 * expected single matching bean but found 2
 */
@Component
@Primary //Se usará como predeterminado. Hay que ponerlo sí o sí porque, si no, Spring no sabe qué Juego coger en contexto.getBean(Juego.class)
public class MarioGame implements Juego {

	@PostConstruct
    public void init() {
        System.out.println("MarioGame Bean ha sido inicializado");
    }
	
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
