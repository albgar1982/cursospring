package com.cursospring.tareasApp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("nom") // Esto hace que nom se incluya en la SESIÓN HTTP del usuario, estando disponible esta info para todas las vistas, no sólo para el modelo welcome.jsp
public class WelcomeController {

	// http://localhost:8080 GET inicial, abre la página de arranque
	@GetMapping("/")
	public String irAWelcome(ModelMap modelo) {
		log.debug("irAWelcome() ha sido llamado");  
		modelo.put("nom", getNombreUsuarioLogueado() ); // Clave/Valor
		return "welcome";
	}
	
	// Obtiene el nombre del usuario del UserDetails que creamos en la configuración de seguridad (en InMemoryUserDetailsManager de SpringSecurityConfiguration)
	private String getNombreUsuarioLogueado() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //en SecurityContextHolder se guardaron los detalles del usuario en el login
		return authentication.getName(); 
	}
}
