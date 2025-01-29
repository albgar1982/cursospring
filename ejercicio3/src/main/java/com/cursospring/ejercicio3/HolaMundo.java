package com.cursospring.ejercicio3;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * El contexto para Spring es el Spring Container, en el que generará los Beans, 
 * que son las instancias que va a manejar el framework.
 * Este Spring Container se crea como un contexto propio para Spring, dentro de la JVM (Java Virtual Machine)
 */
//@SpringBootApplication
public class HolaMundo {

	public static void main(String[] args) {
		
		/* 1 - Vamos a lanzar un Spring Context. Para ello usamos 
		 * AnnotationConfigApplicationContext, que obtiene las definiciones de beans a partir de las clases
		 *  de componentes dadas y actualizando automáticamente el contexto.
		 *
		 * Parámetros:
		 * componentClasses: una o más clases de componentes, por ejemplo, clases @Configuration.
		 */
		var contexto = new AnnotationConfigApplicationContext(HolaMundoConfiguracion.class);
		
		/* 2 - Vamos a configurar las cosas que queremos que maneje Spring. Para ello, 
		 * usamos la anotación @Configuration en la clase HolaMundoConfiguracion, donde estamos definiendo el método
		 * nombre(), que devuelve el String que mostramos por pantalla aquí. Importante el método getBean(nombreDelMetodoQueGeneraElBean)
		 */
		System.out.println(contexto.getBean("nombre"));
		System.out.println(contexto.getBean("persona"));
		System.out.println(contexto.getBean("direccion"));
		
		//No lo reconoce porque hemos dado otro nombre a ese Bean
		//System.out.println(contexto.getBean("edad"));
		System.out.println(contexto.getBean("vueltasALaTierra"));
		
		/* También se puede recuperar (retrieve) un Bean por su clase.
		* Esto es peligrosillo porque, si 2 o más métodos que devuelven Beans de la misma clase -Direccion, por ejemplo-,
		* Spring no puede inferir cuál de ellos ha de usar aquí y lanzará una excepción.
		*/
		System.out.println(contexto.getBean(Direccion.class));
		
		/* Si descomentamos la siguiente línea, saltará esta excepción.
		 * No qualifying bean of type 'com.cursospring.ejercicio3.Persona' available: 
		 * expected single matching bean but found 3: persona,personaCreadaConLlamadasAMetodos,personaCreadaConParametros
		 */
		//System.out.println(contexto.getBean(Persona.class));
		
		System.out.println(contexto.getBean("personaCreadaConLlamadasAMetodos"));
		System.out.println(contexto.getBean("personaCreadaConParametros"));

		/*
		 * Podemos saber el número de Beans que hay en el Spring IoC Container con el método getBeanDefinitionCount()
		 * Para listarlos, creamos un flujo (stream) sobre el String[] que devuelve el método getBeanDefinitionNames()
		 * Como puedes observar, hay varios Beans creados automáticamente por Spring y luego hay otro para la Configuración y los otros que
		 * se corresponden con los creados con la anotación @Bean.
		 */
		System.out.println("Número de Beans en el container: " + contexto.getBeanDefinitionCount() + ". Los listamos:");
		Arrays.stream( contexto.getBeanDefinitionNames() ).forEach( System.out::println );
		
		System.out.println(contexto.getBean("perro"));
		System.out.println(contexto.getBean("perro2"));
		System.out.println(contexto.getBean(Perro.class));//Fallaría al haber 2 métodos que devuelven Beans de la clase Perro, 
		//pero ponemos @Primary y se le dice a Spring cuál coger
		System.out.println(contexto.getBean("personaConPerro"));
		
		
		contexto.close();
	}

}
