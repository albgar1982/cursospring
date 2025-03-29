package com.cursospring.tareasApp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cursospring.tareasApp.model.Tarea;
import com.cursospring.tareasApp.repository.TareaRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("nom") 
@Slf4j
public class TareaControllerJPA {

	private TareaRepository tareaRepository;
	
	//Spring, al crear el controlador (debido al @Controller), hará uso de este constructor e inyectará automáticamente el Bean.
	public TareaControllerJPA(TareaRepository tareaRepository) {
		super();
		this.tareaRepository = tareaRepository;
	}


	@GetMapping(value = "tareas")
	public String obtenerTareas(ModelMap modelMap) {
		//Obtenemos el nombre del usuario de la sesión
		String nombreUsuario = getNombreUsuarioLogueado();
		
		// Obtenemos la lista de Tareas del usuario desde el repositorio.
		List<Tarea> listaTareasOrdenadas = tareaRepository.findByNombreUsuario(nombreUsuario);
		
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
		//Si hay errores de validación, volvemos a la vista tareaNueva.jsp (donde ya estábamos)
		if(result.hasErrors()) { 
			return "tareaNueva";
		}
		String nombreUsuario = getNombreUsuarioLogueado();
		//Creamos un nuevo objeto Tarea con los datos del formulario y lo guardamos en la base de datos
		tareaRepository.save(new Tarea(nombreUsuario, tarea.getDescripcion(),tarea.getFechaObjetivo(), false));
		System.out.println("Tarea guardada con el Id: " + tarea.getId());
		return "redirect:tareas"; //Al hacer el POST, redirigimos a la vista de tareas para que se muestre la lista de tareas actualizada
	}
	
	//Borra la tarea con el Id pasado por parámetro y redirige a la vista de tareas
	@GetMapping(value = "borrar-tarea")
	public String borrarTarea(@RequestParam int id) {
		tareaRepository.deleteById(id); //Borramos la tarea con el Id pasado por parámetro
		return "redirect:tareas";
	}
	
	
	@GetMapping(value = "actualizar-tarea")
	public String actualizaTareaGet(@RequestParam int id, ModelMap modelMap, RedirectAttributes redirectAttributes) {
	    // Buscamos la tarea
		//Tarea tarea = tareaRepository.findById(id).get(); Esto hacen en el curso, pero es mejor hacerlo con Optional
	    Optional<Tarea> tareaOpt = tareaRepository.findById(id);
	    
	    // Si no existe...
	    if (tareaOpt.isEmpty()) {
	        redirectAttributes.addFlashAttribute("error", "La tarea con ID " + id + " no existe");
	        return "redirect:/tareas"; // ...redirigimos al listado de tareas
	    }
	    
	    // Si existe, la añadimos al modelo
	    modelMap.addAttribute("tarea", tareaOpt.get());
	   
	    return "tareaNueva";
	}
	
	@PostMapping(value = "actualizar-tarea")
	public String actualizaTareaPost(@ModelAttribute @Valid Tarea tarea,BindingResult result,ModelMap modelMap,RedirectAttributes redirectAttributes) {

	    // 1. Validación de errores
	    if (result.hasErrors()) {
	        modelMap.addAttribute("tarea", tarea); // Mantener los datos ingresados
	        return "tareaNueva";
	    }

	    // 2. Verificar existencia de la tarea
	    if (!tareaRepository.existsById(tarea.getId())) {
	        redirectAttributes.addFlashAttribute("error", "La tarea ya no existe");
	        return "redirect:/tareas";
	    }

	    try {
	        // 3. Actualizar la tarea
	        String nombreUsuario = getNombreUsuarioLogueado();
	        tarea.setNombreUsuario(nombreUsuario);
	        tarea.setHecho(false); // Aseguramos que no se modifique el estado
	        
	        tareaRepository.save(tarea); // Usamos save() en lugar de actualizaTarea()
	        
	        // 4. Mensaje de éxito
	        redirectAttributes.addFlashAttribute("success", "Tarea actualizada correctamente");
	        
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("error", "Error al actualizar la tarea");
	        log.error("Error al actualizar tarea ID: " + tarea.getId(), e);
	    }

	    return "redirect:/tareas";
	}
	
	//Como hay que mostrar el nombre del usuario en la vista, lo obtenemos del UserDetails que guardamos en la sesión durante el login
	private String getNombreUsuarioLogueado() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
