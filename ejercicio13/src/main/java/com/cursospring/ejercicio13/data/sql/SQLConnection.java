package com.cursospring.ejercicio13.data.sql;

import org.springframework.stereotype.Repository;

import com.cursospring.ejercicio13.data.DatabaseConnection;

@Repository
public class SQLConnection implements DatabaseConnection{

	@Override
	public int[] recuperarDatos() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
}
