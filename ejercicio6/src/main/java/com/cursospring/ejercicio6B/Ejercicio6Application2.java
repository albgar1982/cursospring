package com.cursospring.ejercicio6B;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
class Dependencia3{ }

@Component
class Dependencia4{ }

@Component
class MiClaseDeNegocio2{
	
	private static final Logger log = LoggerFactory.getLogger(MiClaseDeNegocio2.class);

	Dependencia3 dependencia3;
	Dependencia4 dependencia4;
	
	public Dependencia3 getDependencia3() {
		return dependencia3;
	}

	public Dependencia4 getDependencia4() {
		return dependencia4;
	}

	@Autowired //Inyección en los setters(). Ponemos un sout para 
	public void setDependencia3(Dependencia3 dependencia3) {
		log.info("Está ejecutándose el setDependencia3()");
		this.dependencia3 = dependencia3;
	}

	@Autowired
	public void setDependencia4(Dependencia4 dependencia4) {
		log.info("Está ejecutándose el setDependencia4()");
		this.dependencia4 = dependencia4;
	}
	
	//@Override realmente no es necesario
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MiClaseDeNegocio2 [dependencia3=").append(dependencia3).append(", dependencia4=")
				.append(dependencia4).append("]");
		return builder.toString();
	}
}



@Configuration 
@ComponentScan
public class Ejercicio6Application2 {

	public static void main(String[] args) {
		
		try( var context = new AnnotationConfigApplicationContext(Ejercicio6Application2.class) ){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(
					System.out :: println);
			
			System.out.println(context.getBean(MiClaseDeNegocio2 .class));
		}
	}

}
