package com.cursospring.restApiProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.restApiProject.model.Nombre;
import com.cursospring.restApiProject.model.Persona;
import com.cursospring.restApiProject.model.Persona2;

@RestController
public class VersionadoPersonaController {

	//En la URI de la petición, se añade la versión de la API que se quiere utilizar.
	@GetMapping(path = "/v1/personas")
	public Persona devuelvePersonaV1() {
		return new Persona("Fernando Alonso");
	}
	
	@GetMapping(path = "/v2/personas")
	public Persona2 devuelvePersonaV2() {
		return new Persona2(new Nombre("Fernando", "Alonso") );
	}
	
	//Se añade la versión de la API como Request Parameter
	@GetMapping(path = "/personas", params = "version=1")
	public Persona devuelvePersonaV1Params() {
		return new Persona("Fernando Alonso");
	}
	
	@GetMapping(path = "/personas", params = "version=2")
	public Persona2 devuelvePersonaV2Params() {
		return new Persona2(new Nombre("Fernando", "Alonso") );	
	}


	//Se añade la versión de la API como header
	//Por convención, los headers se suelen poner en mayúsculas y empiezan por X y se separan las palabras 
	//con guión normal. Este es un header mío; se pueden crear los que se necesite.
	@GetMapping(path = "/personas/header", headers =  "X-API-VERSION=1") 
	public Persona devuelvePersonaV1Header() {
		return new Persona("Fernando Alonso");
	}
	
	@GetMapping(path = "/personas/header", headers = "X-API-VERSION=2")
	public Persona2 devuelvePersonaV2Header() {
		return new Persona2(new Nombre("Fernando", "Alonso") );	
	}
	
	//Se añade la versión de la API como Accept Header
	@GetMapping(path = "/personas/accept", produces = "application/vnd.restApiProject.app-v1+json") 
	public Persona devuelvePersonaV1Accept() {
		return new Persona("Fernando Alonso");
	}
	
	@GetMapping(path = "/personas/accept", produces = "application/vnd.restApiProject.app-v2+json") 	
	public Persona2 devuelvePersonaV2Accept() {
		return new Persona2(new Nombre("Fernando", "Alonso") );	
	}
}




