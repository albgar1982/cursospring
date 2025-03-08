package com.cursospring.tareasApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("nom") // Esto hace que el atributo que marcamos se incluya en la sesión del usuario,
// estando disponible esta info para todas las vistas.
//Prueba a quitar esto y verás que, en el camino login -> welcome -> vistaTareas, el nombre pasa de la primera a la segunda PERO NO LLEGA a la tercera, debido a que solo está en el modelo, NO en la sesión.
public class ControladorLogin {

	@Autowired
	private ServicioDeAutenticacion autenticacion;

	// http://localhost:8080/login GET inicial, abre la página de arranque
	@GetMapping("login")
	public String irALogin() {
		log.debug("irALogin() ha sido llamado");
		return "login";
	}

	// http://localhost:8080/login POST, con los datos del form
	@PostMapping("login")
	public String irAWelcome(@RequestParam String nombre, @RequestParam String contrasenia, ModelMap modelo) {

		log.debug("irAWelcome() ha sido llamado");

		if (autenticacion.compruebaUsuarioYContrasenia(nombre, contrasenia)) { // Si las credenciales son buenas, nos
																				// lleva a la página de bienvenida
			// Así se pasa info desde el controlador a la vista
			modelo.put("nom", nombre); // Clave/Valor
			modelo.put("con", contrasenia); // Clave/Valor
			return "welcome";
		}
		// Si las credenciales son malas, mostramos el error y relanzamos la misma
		// página
		modelo.put("errorDeAutenticacion", "Credenciales incorrectas. Intente de nuevo:"); // Puedo meter un literal
																							// como valor
		return "login";
	}
}
