package com.cursospring.ejercicio17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * En este ejercicio vemos cómo se crea una clase de configuración -TiendaServicioConfiguracion- en la que se definen varias 
 * propiedades que luego vamos a ir inyectando según el profile que esté vigente en cada momento.
 * Prueba a cambiar de entorno para verlo. También hay un controlador -ControladorConfiguracionTienda- que provee de 
 * un método GET para que lo veas en el navegador.
 * El toString() y los getters de TiendaServicioConfiguracion se han conseguido con @Data de Lombok.
 * 
 * JAMÁS pongas tildes en los .properties!!!!!!!!!!!!!
 * NI SIQUIERA EN LOS COMENTARIOS!!!!!!!!!!!!!!!!!!!!!
 */
@SpringBootApplication
public class Ejercicio17Application {

	public static void main(String[] args) {
		var contexto = SpringApplication.run(Ejercicio17Application.class, args);
		
		TiendaServicioConfiguracion conf = contexto.getBean(TiendaServicioConfiguracion.class);
		System.out.println(conf);
		System.out.println(conf.getNombreUsuario());
		System.out.println(conf.getClave());
	}

}
