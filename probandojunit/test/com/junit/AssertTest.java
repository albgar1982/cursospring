package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AssertTest {

	List<String> listaTareas = Arrays.asList("Cocinar","Comprar","Fregar");
	
	@Test
	void comprobarListaTareas() {
		
		assertEquals(true,listaTareas.contains("Fregar"));
		assertTrue(listaTareas.contains("Comprar"));
		
		assertEquals(false,listaTareas.contains("Hacer cama"));
		assertFalse(listaTareas.contains("Pintar"));
		
		//Esto falla, porque lo que hay que comprobar es que salte la excepción
		//assertNull(listaTareas.get(4));
		assertThrows( IndexOutOfBoundsException.class, () -> listaTareas.get(4) ); //Hay que meter la lambda para que funcione
		
		assertArrayEquals(new String[] {"Cocinar","Comprar","Fregar"}, listaTareas.toArray());
		
		//Te dice exactamente cuál es el primer elemento que no coincide
		//assertArrayEquals(new String[] {"Cocinar","Bailar","Fregar"}, listaTareas.toArray()); 
		
		//Siempre muestra el primero que no coincida, no todos:
		//assertArrayEquals(new int[] {1,2,5},new int[] {1,3,6}, "Los arrays no coinciden"); //El tercer parámetro es el mensaje de error, que salta si lo hay
	
		assertEquals( 3, listaTareas.size() );
	}
}
