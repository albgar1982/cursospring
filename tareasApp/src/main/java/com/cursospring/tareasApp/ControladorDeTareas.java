package com.cursospring.tareasApp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("nom") //Así tenemos acceso a la sesión, en la que habíamos guardado el nombre del usuario durante el login (lo puedes ver en el LoginControlador)
public class ControladorDeTareas {

	private ServicioDeTareas servicioDeTareas;
	
	//Spring, al crear el controlador (debido al @Controller), hará uso de este constructor e inyectará automáticamente el Bean del servicio.
	public ControladorDeTareas(ServicioDeTareas servicioDeTareas) {
		super();
		this.servicioDeTareas = servicioDeTareas;
	}


	@GetMapping(value = "tareas")
	public String obtenerTareas(ModelMap modelMap) {
		
		List<Tarea> listaDeTareas = servicioDeTareas.getTareasPorUsuario("Alberto");
		
		modelMap.put("tareas", listaDeTareas);
		
		return "vistaTareas";
	}
	
	@GetMapping(value = "nueva-tarea")
	public String aniadeTareaNuevaGET() {
		
		return "tareaNueva";
	}
	
	@PostMapping(value = "nueva-tarea")
	public String aniadeTareaNuevaPOST(@RequestParam String descripcion,ModelMap modelMap) {
		String nombreUsuario = (String) modelMap.get("nom");
		servicioDeTareas.ponTarea(nombreUsuario, descripcion,LocalDate.now().plusYears(1), false);
		return "redirect:tareas"; //Con redirect llamamos al endpoint que queramos
	}
}
