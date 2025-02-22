package com.cursospring.ejercicio17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Hemos añadido el starter-web al pom para poder hacer uso de estas anotaciones
public class ControladorConfiguracionTienda {

	@Autowired //Para que Spring inyecte el Bean de TiendaServicioConfiguracion que se crea con @Component en esa clase.
	TiendaServicioConfiguracion tiendaServicioConfiguracion;
	
	// http://localhost:8080/configuracionTienda
	@GetMapping("/configuracionTienda")
	public TiendaServicioConfiguracion devuelveConfiguracionTienda() {
		return tiendaServicioConfiguracion;
	}
	
}
