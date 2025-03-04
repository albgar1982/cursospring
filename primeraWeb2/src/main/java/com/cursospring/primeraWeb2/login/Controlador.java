package com.cursospring.primeraWeb2.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Controlador {
	
	@Autowired
	private ServicioDeAutenticacion autenticacion;
	
	//http://localhost:8080/login GET
	@GetMapping("login")
	public String irALogin() { 
	  log.debug("irALogin() ha sido llamado");
	  return "login";  
	}
  
	//http://localhost:8080/login POST, con los datos del form
	@PostMapping("login")
	public String irAWelcome(@RequestParam String nombre,
		  @RequestParam String contrasenia, ModelMap modelo) { 
	  
	  log.debug("irAWelcome() ha sido llamado");
	  
	  if( autenticacion.compruebaUsuarioYContrasenia(nombre,contrasenia) ) {
		  //Así se pasa info desde el controlador a la vista 
		  modelo.put("nom",nombre); // Clave/Valor
		  modelo.put("con",contrasenia); // Clave/Valor
		  return "welcome";  
	  }
	  modelo.put("errorDeAutenticacion", "Credenciales incorrectas. Intente de nuevo:"); //Puedo meter un literal como valor 
	  return "login";
	}
}

