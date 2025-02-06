package com.cursospring.ejercicio13.data.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.cursospring.ejercicio13.data.DatabaseConnection;

@Repository //Gestiones con la BBDD, normalmente, no como aquí. Se usa la clase para recuperar y/o manipular datos de la BBDD.
@Primary
public class MongoConnection implements DatabaseConnection{

	@Override
	public int[] recuperarDatos() {
		return new int[] { 11, 22, 33, 44, 55 };
	}
}
