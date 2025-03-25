package com.cursospring.tareasApp.security;

import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		//La lambda cumple con la interfaz Function<String, String> (recibe un String -la contra sin encriptar- y retorna otro String -la contra encriptada-).
		Function<String, String> encriptar = entrada -> generaCodificadorContrasenias().encode(entrada);
		//generaCodificadorContrasenias() devuelve un objeto BCryptPasswordEncoder, del cual llamamos al método encode para encriptar la contraseña.
		
		UserDetails user = User.builder()
				.username("Alber")
				.password("Alber123")
				.passwordEncoder(encriptar) 
				.roles("USER","ADMIN")
				.build();
		// passwordEncoder() espera una Function<String, String> que usa un PasswordEncoder internamente.
		// Cuando se ejecuta .build(), Spring aplica encriptar.apply("Alber123") → Llama a generaCodificadorContrasenias().encode("Alber123").

		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public PasswordEncoder generaCodificadorContrasenias() {
		return new BCryptPasswordEncoder();
	}
}


/*  Esta es una opción más sencilla que la del curso.
    @Bean
	public InMemoryUserDetailsManager userDetailsService() {
	    PasswordEncoder encoder = generaCodificadorContrasenias(); // Obtenemos el encoder
	    
	    UserDetails user = User.builder()
	            .username("Alber")
	            .password(encoder.encode("Alber123")) // Hash manual
	            .roles("USER", "ADMIN")
	            .build();
	    
	    return new InMemoryUserDetailsManager(user);
	}
 */
