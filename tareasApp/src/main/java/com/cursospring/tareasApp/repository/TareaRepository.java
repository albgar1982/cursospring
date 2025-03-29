package com.cursospring.tareasApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cursospring.tareasApp.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
	
	// Ejemplo de query personalizada en el repositorio
    List<Tarea> findByNombreUsuario(String nombreUsuario);
}
