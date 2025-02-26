package com.cursospring.ejercicio19.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Usamos la anotación @Entity de jakarta (anteriormente J2EE)
 * para indicar que esta clase mapeará una tabla de la base de datos.
 * Todo ello, según la especificación JPA.
 * 
 * Es obligatorio indicar con @Id cual es la primary key de la tabla.
 * 
 * Si el nombre de la clase no coincide con el de la tabla, usaremos la anotación @Table para especificar el nombre en BD.
 * Si no coinciden los nombres de los atributos de la clase y las columnas de la tabla, usaremos @Column para hacer el mapeo.
 */
@Entity
@Table(name = "cursos") //Nota que este es el nombre en el schema.sql, si no ponemos esto, H2 creará DOS tablas, una llamada curso por el @Entity de aquí y otra llamada cursos por la creación de esa tabla en el schema.sql
public class Curso {

	@Id
	private long id;
	
	@Column(name = "nombre_curso")
	private String nombreCurso;
	
	@Column(name = "nombre_autor")
	private String nombreAutor;
	
	public Curso() {
		super();
	}

	public Curso(long id, String nombreCurso, String nombreAutor) {
		super();
		this.id = id;
		this.nombreCurso = nombreCurso;
		this.nombreAutor = nombreAutor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombreCurso=" + nombreCurso + ", nombreAutor=" + nombreAutor + "]";
	}
}
