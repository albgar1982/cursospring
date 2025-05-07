package com.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeforeAfterTest {

	@BeforeEach
	void antesDeCadaTest() {
		System.out.println("Me ejecuto antes de cada método que lleve la anotación @Test");
	}
	
	@AfterEach
	void trasCadaTest() {
		System.out.println("Me ejecuto después de cada método que lleve la anotación @Test");
	}
	
	//Si no se pone la anotación @TestInstance(Lifecycle.PER_CLASS) el método @BeforeAll tiene que ser estático
    //org.junit.platform.commons.JUnitException: @BeforeAll method 'void com.junit.BeforeAfterTest.antesTodosLosTests()' must be static unless the test class is annotated with @TestInstance(Lifecycle.PER_CLASS).
	@BeforeAll //Va a ser SIEMPRE el primero en ejecutarse
	static void antesTodosLosTests() {
		System.out.println("Preparando los tests...");
	}
	
	//Ha de ser estático también.
	@AfterAll //Va a ser SIEMPRE el último en ejecutarse.
	static void trasTodosLosTests() {
		System.out.println("Los tests han finalizado correctamente.");
	}
	
	@Test
	void test1() {
		System.out.println("Ejecutando... Test 1");
	}

	@Test
	void test2() {
		System.out.println("Ejecutando... Test 2");
	}
	
	@Test
	void test3() {
		System.out.println("Ejecutando... Test 3");
	}
}
