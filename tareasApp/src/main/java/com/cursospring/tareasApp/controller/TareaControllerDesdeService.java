package com.cursospring.tareasApp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cursospring.tareasApp.model.Tarea;
import com.cursospring.tareasApp.service.TareasService;

import jakarta.validation.Valid;

//@Controller DESCOMENTAR ESTE Y COMENTAR EL DE TareaController y este será el controlador, escuchando las requests sobre los endpoints. Si no, coinciden y Spring falla, al no saber a cuáles disparar. Recuerda, este recoge y salva las tareas del mismo servicio, de la lista estática.
@SessionAttributes("nom") //Así tenemos acceso a la sesión, en la que habíamos guardado el nombre del usuario durante el login (ahora ya es la parte de la vista welcome.jsp)
public class TareaControllerDesdeService {

	private TareasService servicioDeTareas;
	
	//Spring, al crear el controlador (debido al @Controller), hará uso de este constructor e inyectará automáticamente el Bean del servicio.
	public TareaControllerDesdeService(TareasService servicioDeTareas) {
		super();
		this.servicioDeTareas = servicioDeTareas;
	}


	@GetMapping(value = "tareas")
	public String obtenerTareas(ModelMap modelMap) {
		//Obtenemos el nombre del usuario de la sesión
		String nombreUsuario = getNombreUsuarioLogueado();
		
		List<Tarea> listaTareasOrdenadas = servicioDeTareas.getTareasPorUsuario(nombreUsuario);
		
		//Añadimos la lista de tareas al ModelMap para que la vista pueda iterarla y mostrar las tareas
		modelMap.put("tareas",listaTareasOrdenadas); 
		return "vistaTareas";
	}
	
	//Devuelve el nombre de la vista tareaNueva.jsp, que contiene el formulario para añadir una nueva tarea. Aquí aún no hay modelo de la tarea, el que le pasamos es "a rellenar" con los datos del formulario
	@GetMapping(value = "nueva-tarea")
	public String mostrarFormularioTarea(ModelMap modelMap) {
		String nombreUsuario = getNombreUsuarioLogueado();
		Tarea tarea = new Tarea(0, nombreUsuario, "", LocalDate.now(), false); //Creamos un objeto Tarea vacío para que el formulario de la vista tareaNueva.jsp pueda enlazarlo con sus campos (mapear el formulario de la vista a esta tarea)
		modelMap.put("tarea", tarea); //Añadimos el objeto Tarea al ModelMap para que la vista pueda acceder a él. El nombre que usamos aquí es el que usamos en el form:form de la vista tareaNueva.jsp
		return "tareaNueva"; //Devolvemos al front la vista tareaNueva.jsp
	}
	
	@PostMapping(value = "nueva-tarea")
	public String enviarFormularioTarea(ModelMap modelMap,@ModelAttribute @Valid Tarea tarea //Recogemos el objeto Tarea que Spring ha creado automáticamente con los datos del formulario (enlazados desde la vista tareaNueva usando modelAttribute="tarea" en la etiqueta form:form del formulario en la vista. Hay que poner @Valid para que se apliquen las validaciones que están en su clase (se aplican en el front)
			,BindingResult result) { //Este parámetro captura los errores de validación que se produzcan
		//Si hay errores de validación, volvemos a la vista tareaNueva.jsp (donde estábamos)
		if(result.hasErrors()) { 
			return "tareaNueva";
		}
		String nombreUsuario = getNombreUsuarioLogueado();
		servicioDeTareas.ponTarea(nombreUsuario, tarea.getDescripcion(),tarea.getFechaObjetivo(), false);
		return "redirect:tareas"; //Con redirect llamamos al ENDPOINT que queramos
	}
	
	//Borra la tarea con el Id pasado por parámetro y redirige a la vista de tareas
	@GetMapping(value = "borrar-tarea")
	public String borrarTarea(@RequestParam int id) {
		servicioDeTareas.borraPorId(id);
		return "redirect:tareas";
	}
	
	
	//Devuelve el nombre de la vista tareaNueva.jsp, añadiendo al modelo la tarea que hemos buscado por su Id (enviado por parámetro), que es la que colocamos en la vista para ser actualizada
	@GetMapping(value = "actualizar-tarea")
	public String actualizaTareaGet(@RequestParam int id,ModelMap modelMap) {
		Tarea tarea = servicioDeTareas.recuperaTareaPorId(id);
		modelMap.put("tarea", tarea); //Añadimos el objeto Tarea al ModelMap para que la vista pueda acceder a él. El nombre que usamos aquí es el que usamos en el form:form de la vista tareaNueva.jsp
		return "tareaNueva";
	}
	
	@PostMapping(value = "actualizar-tarea")
	public String actualizaTareaPost(ModelMap modelMap,@ModelAttribute @Valid Tarea tarea //Recogemos el objeto Tarea que Spring ha creado automáticamente con los datos del formulario (enlazados desde la vista tareaNueva usando modelAttribute="tarea" en la etiqueta form:form del formulario en la vista. Hay que poner @Valid para que se apliquen las validaciones que están en su clase (se aplican en el front)
			,BindingResult result) { //Este parámetro captura los errores de validación que se produzcan
		
		if(result.hasErrors())  //Si hay errores de validación, volvemos a la vista tareaNueva.jsp (donde estábamos)
			return "tareaNueva";
		
		String nombreUsuario = getNombreUsuarioLogueado();
		servicioDeTareas.actualizaTarea(tarea.getId(),nombreUsuario, tarea.getDescripcion(),tarea.getFechaObjetivo(), false);
		return "redirect:tareas"; //Con redirect llamamos al ENDPOINT que queramos
	}
	
	//Como hay que mostrar el nombre del usuario en la vista, lo obtenemos del UserDetails que guardamos en la sesión durante el login
	private String getNombreUsuarioLogueado() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
