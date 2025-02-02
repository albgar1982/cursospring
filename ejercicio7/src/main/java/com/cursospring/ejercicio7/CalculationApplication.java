package com.cursospring.ejercicio7;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cursospring.ejercicio7.servicios.BusinessCalculationService;

@Configuration
@ComponentScan
public class CalculationApplication {

	public static void main(String[] args) {
		
		try( var contexto = new AnnotationConfigApplicationContext(CalculationApplication.class)){
			
			Arrays.stream( contexto.getBeanDefinitionNames() )
				.forEach( System.out :: println);
			
			BusinessCalculationService businessCalculationService = contexto.getBean(BusinessCalculationService.class);
			
			System.out.println("El máximo del array es: " + businessCalculationService.findMax());
		}
	}

}
