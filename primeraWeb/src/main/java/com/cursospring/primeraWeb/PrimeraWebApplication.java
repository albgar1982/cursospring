package com.cursospring.primeraWeb;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Primera web hecha con Spring. En el pom incluímos Spring web y DevTools, para que se carguen los cambios automáticamente sin tener que 
 * arrancar de nuevo el servidor con cada cambio.
 */
@SpringBootApplication
public class PrimeraWebApplication {

	public static void main(String[] args) {
		var contexto = SpringApplication.run(PrimeraWebApplication.class, args);
		
		/*
		Arrays.stream( contexto.getBeanDefinitionNames() )
		.forEach( System.out :: println);
		*/
	}

}
