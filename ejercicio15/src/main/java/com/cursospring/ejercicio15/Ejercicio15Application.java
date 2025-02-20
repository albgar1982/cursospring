package com.cursospring.ejercicio15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Hemos generado este proyecto añadiendo desde Spring Initializr la dependencia spring-boot-starter-web
 * Al arrancar la app, verás que el servidor se levanta en el puerto 8080 (Tomcat started on port 8080)
 * Para llamar al Rest API que hemos levantado, http://localhost:8080/cursos
 * 
 * He instalado Json Formatter en Edge para que los JSon se vean bonito.
 * 
 * En el explorador de proyectos de la izquierda, en nuestro proyecto, podemos desplegar las Maven Dependencies
 * y, en spring-boot-autoconfigure-3.4.2.jar, si desplegamos, veremos todo lo que Spring Boot 3.4.2 va a autoconfigurar
 * al arranque si no configuramos nada nosotros.
 * 
 * En /ejercicio15/src/main/resources/application.properties podemos definif el nivel de log (registro) mostrado al correr 
 * la app. Esto se hace en la propiedad logging.level.org.springframework
 * Ponemos debug y podemos ver al correr la app:
 *  ============================
	CONDITIONS EVALUATION REPORT
	============================
	
	Positive matches: Aquí se muestran las que se han autoconfigurado y en 
	-----------------
	
	Negative matches: las que no.
	----------------- 
	Toda esa autoconfiguración se basa en lo que vemos en spring-boot-autoconfigure-3.4.2.jar
	Se puede abrir cualquiera de esas clases haciendo ctrl + C y luego sobre ella en la lista ctrl + shift + T
	En la ventana que se abre, hacemos ctrl + V. Una vez abierta, para localizarla en el Projecy Explorer, hay un botoncito arriba
	de éste con 2 flechitas amarillas que nos mostrará su ubicación en las dependencias.
	
	Por ejemplo, si entramos en la clase ErrorMvcAutoConfiguration, veremos el siguiente mensaje que es lo que se muestra por 
	defecto cuando fallamos al escribir la URL (pruébalo):
	
	builder.append("<html><body><h1>Whitelabel Error Page</h1>")
				.append("<p>This application has no explicit mapping for /error, so you are seeing this as a fallback.</p>")
				.append("<div id='created'>")
				.append(timestamp)
				.append("</div>")
				.append("<div>There was an unexpected error (type=")
				.append(htmlEscape(model.get("error")))
				.append(", status=")
				.append(htmlEscape(model.get("status")))
				.append(").</div>");
	
	Esto ya nos viene autoconfigurado por Spring Boot.
	
	
	
	
	Por otra parte, en el POM incluimos un starter nuevo, el devtools, que nos permite hacer cambios en el proyecto y que el 
	servidor se cargue automáticamente y muy rápidamente en cuanto salvemos el archivo que hayamos modificado, sin tener que hacer stop -> start
	
	Además, hicimos cambios en application.properties para cambiar el nivel del logging
	/ejercicio15/src/main/resources/application.properties
 */
@SpringBootApplication
public class Ejercicio15Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio15Application.class, args);
	}

}
