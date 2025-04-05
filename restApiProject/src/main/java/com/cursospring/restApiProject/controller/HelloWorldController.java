package com.cursospring.restApiProject.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.restApiProject.model.MensajeBean;

@RestController
public class HelloWorldController {
	
	//MessageSource es el bean que nos permite acceder a los mensajes de los ficheros de propiedades
	private MessageSource messageSource;
	
	//Inyectamos el bean MessageSource para poder acceder a los mensajes de los ficheros de propiedades
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping(path = "/hola-mundo") //No es necesario poner path =, bastaría con @GetMapping("/hola-mundo")
	public String devuelveHolaMundo() {
		return "Hola mundo";
	}
	
	@GetMapping(path = "/hola-mundo-bean") //No es necesario poner path =, bastaría con @GetMapping("/hola-mundo")
	public MensajeBean devuelveHolaMundoBean() {
		return new MensajeBean("Spring ha transformado el MensajeBean a un objeto JSON, gracias a la anotación @RestController.");
	}
	
	//La anotación @PathVariable nos permite recibir un parámetro en la URL, que en este caso se compone de una parte fija y una variable (nombre)
	@GetMapping("/hola-mundo/path-variable/{nombre}") 
	public MensajeBean devuelveHolaMundoPathVariable(@PathVariable String nombre) {
		return new MensajeBean(String.format("Hola, %s", nombre));
	}
	
	@GetMapping("/buenos-dias") 
	public String buenosDiasEnIdiomaRequerido() {
		//Cogemos el locale del contexto de la aplicación. En él, se guarda el idioma que el usuario ha seleccionado en su navegador
		Locale locale = LocaleContextHolder.getLocale();
		//Cogemos el mensaje del fichero de propiedades que corresponda al idioma del locale
		return messageSource.getMessage("good.morning.message", null,"Mensaje por defecto.", locale);   
		//El segundo parámetro es para pasar argumentos al mensaje, en este caso no necesitamos ninguno   
		//El tercer parámetro es el mensaje por defecto, que se mostrará si no se encuentra el mensaje en el fichero de propiedades.
	}
}
