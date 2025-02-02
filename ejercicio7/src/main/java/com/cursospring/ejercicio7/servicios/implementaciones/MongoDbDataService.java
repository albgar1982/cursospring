package com.cursospring.ejercicio7.servicios.implementaciones;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.cursospring.ejercicio7.servicios.DataService;

@Component
@Primary
public class MongoDbDataService implements DataService{

	@Override
	public int[] recuperarDatos() {
		return new int[] { 11, 22, 33, 44, 55 };
	}
}
