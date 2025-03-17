package com.cursospring.tareasApp;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service //Spring generará un Bean y lo inyectará en el constructor del controlador (inyección de dependencias)
public class ServicioDeTareas {

	private static HashMap<Integer,Tarea> tareas = new HashMap<>();
	private static int contadorDeTareas; //Estático para que pertenezca a la clase y cada tarea acceda al mismo sumándole uno más. Va a ser el Id de las tareas.
	
	static {
		tareas.put( ++contadorDeTareas,new Tarea(contadorDeTareas, "Alberto", "Aprender Spring", LocalDate.now().plusYears(1), false) ); //now() devuelve la fecha actual y plusYears() añade el número de años pasados como argumento
		tareas.put( ++contadorDeTareas,new Tarea(contadorDeTareas, "Alberto", "Aprender Git", LocalDate.now().plusYears(1), false) ); 
		tareas.put( ++contadorDeTareas,new Tarea(contadorDeTareas, "Alberto", "Aprender Angular", LocalDate.now().plusYears(2), false) ); 
	}
	
	public HashMap<Integer,Tarea> getTareasPorUsuario(String usuario){
		return tareas;
	}
	
	public void ponTarea(String nombreUsuario, String descripcion, LocalDate fechaObjetivo, boolean hecho) {
		tareas.put( ++contadorDeTareas,new Tarea(contadorDeTareas,nombreUsuario,descripcion,fechaObjetivo,hecho) );
	}

	public void borraPorId(int id) {
		if( tareas.containsKey(id) ) 
			tareas.remove(id); 
		/*
		 Si el Id no existe, no se hace nada.
		 En el curso no están usando un mapa, sino una List<Tarea>, por lo que el borrado se hace de otra forma, usando el método
		 removeIf() de la interfaz List, que recibe un predicado (una expresión lambda que devuelve true o false) 
		 y borra los elementos que cumplan la condición.
		 En este caso, el predicado sería tarea -> tarea.getId() == id    (la función lambda)
		 
		public void deleteById(int id) {
			Predicate<? super Tarea> predicate = tarea -> tarea.getId() == id;
			tareas.removeIf(predicate);
		}
		 */
	}
}
