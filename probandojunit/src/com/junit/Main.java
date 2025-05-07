package com.junit;

public class Main {

	public static void main(String[] args) {
		int[] arrayNumeros = { 1, 2, 3, 4, 5 };
		Matematicas mates = new Matematicas();
		System.out.println( mates.suma(arrayNumeros) );
	}
}