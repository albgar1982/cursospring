package com.cursospring.tareasApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class TareasAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareasAppApplication.class, args);
	}

	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true); // Asegura que la codificacion se aplique incluso si ya esta establecida
		return filter;
	}
}
