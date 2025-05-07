package com.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//JUnit no asegura el orden de ejecución de los métodos	marcados con @Test, 
//existiendo para ello distintas anotaciones como @BeforeAll, @BeforeEach, @AfterAll y @AfterEach.
class MatematicasTest {

	private Matematicas matematicas = new Matematicas();

	@Test
	void probarSumarConArrayDe3Argumentos() {
		assertEquals(6, matematicas.suma(new int[] { 1, 2, 3 }));
	}
	
	@Test
	void probarSumarArrayVacio() {
		assertEquals(0, matematicas.suma(new int[] {}));
	}

}
