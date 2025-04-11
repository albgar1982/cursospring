package com.cursospring.restApiProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

// CSRF (Cross-Site Request Forgery) es una técnica de ataque que permite a un atacante ejecutar acciones no autorizadas en nombre de un usuario autenticado.
// En esta clase vamos a configurar la seguridad del API REST para que no permita ataques CSRF, pero que cumpla las condiciones de autenticación que le demos nosotros.
@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
        http.authorizeHttpRequests( autorizacion -> autorizacion.anyRequest().authenticated() ); // Permitir todas las peticiones que estén autenticadas
        
        http.httpBasic(withDefaults()); // Configuración básica de autenticación HTTP. 
        //Hemos importado el método withDefaults(), que es estático de la clase Customizer para simplificar la configuración.
        //Si una request no tiene autenticación, se le pide al usuario que introduzca su usuario y contraseña en una web básica.
        
        http.csrf( csrf -> csrf.disable() ); // Deshabilitar CSRF (Falsificación de Solicitud Entre Sitios).
        
		return http.build();
	}
}
