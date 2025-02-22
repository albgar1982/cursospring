package com.cursospring.ejercicio17;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@ConfigurationProperties(prefix = "tienda-servicio")
@Component
@Data
public class TiendaServicioConfiguracion {

	private String url;
	private String nombreUsuario;
	private String clave;
}
