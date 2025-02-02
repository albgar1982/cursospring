package com.cursospring.ejercicio7.servicios.implementaciones;

import org.springframework.stereotype.Component;
import com.cursospring.ejercicio7.servicios.DataService;

@Component
public class MySQLDataService implements DataService{

	@Override
	public int[] recuperarDatos() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
}
