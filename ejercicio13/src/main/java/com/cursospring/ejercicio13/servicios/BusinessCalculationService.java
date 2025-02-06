package com.cursospring.ejercicio13.servicios;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.cursospring.ejercicio13.data.DatabaseConnection;

@Service //Aquí está la lógica de la aplicación
public class BusinessCalculationService { // Aquí tenemos la lógica

	private DatabaseConnection dataService; //Es una dependencia de BusinessCalculationService

	//Usamos inyección de dependencias en el constructor. No necesitamos el @Autowired
	public BusinessCalculationService(DatabaseConnection dataService) {
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.recuperarDatos()).max().orElse(0);
	}
}
