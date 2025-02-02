package com.cursospring.ejercicio6A;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component //Se crea un Bean
class Dependencia1{ }

@Component //Se crea un Bean
class Dependencia2{ } 



@Component //Se crea un Bean
class MiClaseDeNegocio{ //Recuerda, en el mismo fichero SOLO puede haber una public class
	
	//@Autowired //Esto es lo que se llama inyección en campo 'field injection'
	Dependencia1 dependencia1;
	
	//@Autowired
	Dependencia2 dependencia2;
	
	public String toString() {
		return "La clase " + this.getClass().getSimpleName() + " está usando estas dependencias:\n" 
				+ dependencia1 + "\n" + dependencia2;
	}
}


@Configuration //No busca Beans por sí misma
@ComponentScan //Busca componentes para crear sus Beans en ESTE paquete y sus subpaquetes
public class Ejercicio6Application1 {

	public static void main(String[] args) {
		
		try( var context = new AnnotationConfigApplicationContext(Ejercicio6Application1.class) ){
			
			//Mostramos todos los Beans creados (SOLO los nombres, getBeanDefinitionNames() no nos proporciona los Beans en sí mismos)
			Arrays.stream(context.getBeanDefinitionNames()).forEach(
					System.out :: println);
			
			/*
			 * Vemos que Spring no inyecta las dependencias directamente, son null, como son siempre los atributos de Clase que no sean inicializados.
			 * Por existir, SÍ que existen los Beans de esas clases; como puedes ver, se muestran los nombres dependencia1 y dependencia2 al
			 * hacer el getBeanDefinitionNames(), pero, insistimos, NO son inyectados por defecto. Para inyectar ESOS Beans en esos atributos,
			 * podemos usar la anotación @Autowired. Descoméntala y ve cómo los inyecta.
			*/
			System.out.println(context.getBean(MiClaseDeNegocio.class));
		}
	}

}
