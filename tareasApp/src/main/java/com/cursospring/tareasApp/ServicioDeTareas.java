package com.cursospring.tareasApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //Spring generará un Bean y lo inyectará en el constructor del controlador (inyección de dependencias)
public class ServicioDeTareas {

	private static List<Tarea> tareas = new ArrayList<Tarea>();
	
	private static int contadorDeTareas; //Estático para que pertenezca a la clase y cada tarea acceda al mismo sumándole uno más.
	
	static {
		tareas.add( new Tarea(++contadorDeTareas, "Alberto", "Aprender Spring", LocalDate.now().plusYears(1), false) ); //now() devuelve la fecha actual y plusYears() añade el número de años pasados como argumento
		tareas.add( new Tarea(++contadorDeTareas, "Alberto", "Aprender Git", LocalDate.now().plusYears(1), false) ); 
		tareas.add( new Tarea(++contadorDeTareas, "Alberto", "Aprender Angular", LocalDate.now().plusYears(2), false) ); 
	}
	
	public List<Tarea> getTareasPorUsuario(String usuario){
		return tareas;
	}
	
	public void ponTarea(String nombreUsuario, String descripcion, LocalDate fechaObjetivo, boolean hecho) {
		tareas.add( new Tarea(++contadorDeTareas,nombreUsuario,descripcion,fechaObjetivo,hecho) );
	}
}
