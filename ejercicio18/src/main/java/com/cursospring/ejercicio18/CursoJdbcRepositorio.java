package com.cursospring.ejercicio18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //Indica que la clase interactúa con la base de datos
public class CursoJdbcRepositorio {

	// Gestiona conexiones, prepara sentencias y maneja excepciones. En este caso vamos a usarla para preparar una sentencia que vamos a ejecutar con su método update()
	@Autowired
	private JdbcTemplate plantillaSpringJdbc;
	
	//La CONSTANTE con el literal de la sentencia que queremos ejecutar. Con la triple comilla, nos respetan el salto de línea. Lee más al final de esta clase.
	private static String INSERT_QUERY =
			"""
				INSERT INTO CURSOS(ID,CURSO,AUTOR) 
				VALUES (?,?,?)
			""";
	
	private static String DELETE_QUERY =
			"""
				DELETE FROM CURSOS
				WHERE ID = ?
			""";
	
	private static String SELECT_QUERY =
			"""
				SELECT * FROM CURSOS
				WHERE ID = ?
			""";
	
	public void insert(Curso curso) {
		// update() ejecuta la sentencia SQL, tales como insert, update o delete.
		plantillaSpringJdbc.update(INSERT_QUERY,curso.getId(),curso.getCurso(),curso.getAutor()); 
	}
	
	public void delete(long id) {
		plantillaSpringJdbc.update(DELETE_QUERY,id);
	}

	public Curso select(long id) {

		//En los apuntes se habla sobre queryForObject( sql, rowMapper, args )
		return plantillaSpringJdbc.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Curso.class),id);
	}
}

/* Triple comillas (text blocks):
 * Permiten definir cadenas multilínea de forma más legible y natural, manteniendo los saltos de línea
 * y el formato tal y como se escribe en el código.
 * Reducen la necesidad de escapar caracteres especiales (como las comillas dobles internas) y de concatenar líneas.
 * 
 * Comillas dobles simples (cadena tradicional):
 * Se usan para definir cadenas en una sola línea.
 * Si se desea una cadena multilínea, es necesario concatenar varias cadenas o incluir caracteres de nueva línea explícitos (\n).
 * Requiere escapar caracteres especiales manualmente.
 */
