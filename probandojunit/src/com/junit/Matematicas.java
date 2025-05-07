package com.junit;

import java.util.Arrays;

public class Matematicas {

	public int suma(int[] arrayNumeros) {
		int resultado = 0;
		resultado = Arrays.stream(arrayNumeros).sum();
		return resultado;
	}
}