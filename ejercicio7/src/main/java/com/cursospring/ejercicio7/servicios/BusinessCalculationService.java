package com.cursospring.ejercicio7.servicios;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService { // Aquí tenemos la lógica

	private DataService dataService; //Es una dependencia de BusinessCalculationService

	//Usamos inyección de dependencias en el constructor. No necesitamos el @Autowired
	public BusinessCalculationService(DataService dataService) {
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.recuperarDatos()).max().orElse(0);
	}
}
