package com.cursospring.tareasApp.security;

import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public PasswordEncoder generaCodificadorContrasenias() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails userDetails1 = crearNuevoUsuario("Alber", "Alber123", List.of("USER", "ADMIN"));
        UserDetails userDetails2 = crearNuevoUsuario("Laura", "Laura123", List.of("USER"));

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails crearNuevoUsuario(String username, String password, List<String> listaDeRoles) {
        Function<String, String> encriptar = entrada -> generaCodificadorContrasenias().encode(entrada);

        return User.builder()
                .username(username)
                .password(password)
                .passwordEncoder(encriptar)
                .roles(listaDeRoles.toArray( new String[0] ) ) 
                .build();
    }
    
    
    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//Todas las solicitudes requieren autenticación
		http.authorizeHttpRequests( auth -> auth.anyRequest().authenticated() );
		//Usa el formulario de login por defecto de Spring Security. Hemos hecho el import del método estático withDefaults()
		http.formLogin( withDefaults() );
		// Deshabilita la protección CSRF (NO recomendado para aplicaciones web tradicionales) para el endpoint de la consola H2.
		http.csrf(csrf -> csrf.ignoringRequestMatchers("/consolaH2TareasApp/**"));
		//Permite que la aplicación muestre frames SOLO del mismo origen
		http.headers( headers -> headers.frameOptions( frame -> frame.sameOrigin() ) ); 
	                
		return http.build();
	}
}
