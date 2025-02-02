package com.cursospring.ejercicio6C;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
class Dependencia5{ }

@Component
class Dependencia6{ }

@Component
class MiClaseDeNegocio3{
	
	private static final Logger log = LoggerFactory.getLogger(MiClaseDeNegocio3.class);

	
	Dependencia5 dependencia5;
	Dependencia6 dependencia6;
	
	@Autowired //NO es necesario ponerlo. Al crear el Bean de MiClaseDeNegocio3, Spring va a inyectar automáticamente las dependencias (auto-wiring) por estar el constructor (inyectará los Beans de los parámetros que tenga el constructor)
	public MiClaseDeNegocio3(Dependencia5 dependencia5, Dependencia6 dependencia6) {
		log.info("Está ejecutándose el constructor de MiClaseDeNegocio3");
		this.dependencia5 = dependencia5;
		this.dependencia6 = dependencia6;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MiClaseDeNegocio3 [dependencia5=").append(dependencia5).append(", dependencia6=")
				.append(dependencia6).append("]");
		return builder.toString();
	}
}



@Configuration 
@ComponentScan
public class Ejercicio6Application3 {

	public static void main(String[] args) {
		
		try( var context = new AnnotationConfigApplicationContext(Ejercicio6Application3.class) ){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(
					System.out :: println);
			
			System.out.println(context.getBean(MiClaseDeNegocio3 .class));
		}
	}

}
