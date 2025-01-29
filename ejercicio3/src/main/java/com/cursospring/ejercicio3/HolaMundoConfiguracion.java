package com.cursospring.ejercicio3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/*
 * record crea la clase con constructor con todos los argumentos, getters, toString, equals y hashCode.
 * Es como data class en Kotlin. Los campos son inmutables. Hay más info en los apuntes. Desde Java 16.
 */
record Persona (String nombre, int edad,Direccion direccion){};
record Direccion (String calle, String ciudad){};
record Perro (String nombre, int edad){};
record PersonaConPerro (String nombre, Perro perro){};


/* Indica que una clase declara uno o más métodos @Bean y puede ser procesada 
*  por el contenedor de Spring para generar definiciones de beans y solicitudes 
*  de servicio para esos beans en tiempo de ejecución.
*/
@Configuration 
public class HolaMundoConfiguracion {

	// Indica que el método produce una judía para que la maneje el contenedor de Spring
	@Bean
	public String nombre() {
		return "Alberto";
	}
	/*
	 * Desde el contexto, poniendo en su método getBean("nombreDelMetodo"), así, sin () y con comillas,
	 * conseguiremos rescatar el bean producido en tiempo de ejecución por Spring, que recibe el nombre del método que lo creó; en este 
	 * caso "nombre"
	 */
	
	//Podemos crear un Bean que sea un objeto 
	@Bean
	public Persona persona() {
		return new Persona("Laura",46,direccion()); //direccion() recogerá el otro Bean
	}
	
	@Bean
	public Direccion direccion() {
		return new Direccion("Fuente del tiro", "Madrid");
	}
	
	// Con el atributo 'name' podemos renombrar el Bean para que tome ese nombre EN VEZ DEL NOMBRE DEL MÉTODO. 
	@Bean (name = "vueltasALaTierra")
	public int edad() {
		return 42;
	}
	
	//Podemos crear un nuevo Bean CON OTROS BEANS con llamadas a los métodos
	@Bean
	public Persona personaCreadaConLlamadasAMetodos() {
		return new Persona(nombre(),edad(),direccion()); //Nota que llamamos al método edad(), no al Bean. Por eso no usamos el nombre dado en el atributo name de la anotación
	}
	
	/* Podemos crear un nuevo Bean CON OTROS BEANS pasados como parámetros. 
	 * Los nombres HAN DE COINCIDIR con los de los Beans (en el caso de los que tienen su nombre por defecto (el del método)
	 * y pueden ser llamados con el nombre del método o del atributo 'name' de la anotación @Bean en el caso de tenerlo.
	 * En este ejemplo concreto, vueltasALaTierra podría ser edad perfectamente y funciona igual. 
	 * Crear Beans usando otros es hacer auto-wiring, conectarlos por parámetros.
	 */
	@Bean
	public Persona personaCreadaConParametros(String nombre,int vueltasALaTierra,Direccion direccion) {
		return new Persona(nombre,vueltasALaTierra,direccion); //Van sin paréntesis, ya que son los parámetros
	}
	
	@Bean
	@Primary
	public Perro perro() {
		return new Perro("Toby",5);
	}
	
	@Bean
	@Qualifier("McGuire")
	public Perro perro2() {
		return new Perro("McGuire",2);
	}
	
	@Bean
	public PersonaConPerro personaConPerro(String nombre, @Qualifier("McGuire")Perro perro) { //NOTA que el parámetro coge el nombre del método perro y no perro2; es el Qualifier el que dice cuál usar en la inyección de dependencias
		return new PersonaConPerro(nombre,perro); 
	}
	
}
