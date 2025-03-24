package com.cursospring.tareasApp;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
		List<Tarea> listaTareasOrdenadas = servicioDeTareas.getTareasPorUsuario("Alberto").entrySet().stream() //Obtenemos las tareas y creamos un flujo sobre las entradas del Map
                .sorted(Map.Entry.comparingByKey()) // Ordenamos las tareas por clave (el Id de la tarea)
                .map( (Map.Entry<Integer, Tarea> entry) -> entry.getValue()) //Nos quedamos con los valores (las tareas)
                .collect(Collectors.toList()); //Convertimos el flujo en una lista
		modelMap.put("tareas",listaTareasOrdenadas); 
		return "vistaTareas";
	}
	
	//Devuelve el nombre de la vista tareaNueva.jsp, que contiene el formulario para añadir una nueva tarea. Aquí aún no hay modelo de la tarea
	@GetMapping(value = "nueva-tarea")
	public String mostrarFormularioTarea(ModelMap modelMap) {
		String nombreUsuario = (String) modelMap.get("nom");
		Tarea tarea = new Tarea(0, nombreUsuario, "", LocalDate.now(), false); //Creamos un objeto Tarea vacío para que el formulario de la vista tareaNueva.jsp pueda enlazarlo con sus campos (mapear el formulario de la vista a esta tarea)
		modelMap.put("tarea", tarea); //Añadimos el objeto Tarea al ModelMap para que la vista pueda acceder a él. El nombre que usamos aquí es el que usamos en el form:form de la vista tareaNueva.jsp
		return "tareaNueva"; //Devolvemos al front la vista tareaNueva.jsp
	}
	
	
	/* Método que recoge los datos del formulario de la vista tareaNueva.jsp y añade
	 * una nueva tarea a la lista de tareas del usuario.
	 * Lo desechamos porque vamos a usar un formulario con un Bean de la Tarea.
	 * 
	@PostMapping(value = "nueva-tarea")
	public String aniadeTareaNuevaPOST(@RequestParam String descripcion,ModelMap modelMap) {
		String nombreUsuario = (String) modelMap.get("nom");
		servicioDeTareas.ponTarea(nombreUsuario, descripcion,LocalDate.now().plusYears(1), false);
		return "redirect:tareas"; //Con redirect llamamos al ENDPOINT que queramos
	}
	*/
	
	@PostMapping(value = "nueva-tarea")
	public String enviarFormularioTarea(ModelMap modelMap,@ModelAttribute @Valid Tarea tarea //Recogemos el objeto Tarea que Spring ha creado automáticamente con los datos del formulario (enlazados desde la vista tareaNueva usando modelAttribute="tarea" en la etiqueta form:form del formulario en la vista. Hay que poner @Valid para que se apliquen las validaciones que están en su clase (se aplican en el front)
			,BindingResult result) { //Este parámetro captura los errores de validación que se produzcan
		//Si hay errores de validación, volvemos a la vista tareaNueva.jsp (donde estábamos)
		if(result.hasErrors()) { 
			return "tareaNueva";
		}
		String nombreUsuario = (String) modelMap.get("nom");
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
		
		String nombreUsuario = (String) modelMap.get("nom");
		servicioDeTareas.actualizaTarea(tarea.getId(),nombreUsuario, tarea.getDescripcion(),tarea.getFechaObjetivo(), false);
		return "redirect:tareas"; //Con redirect llamamos al ENDPOINT que queramos
	}
}
