package com.cursospring.ejercicio15;

public class Curso {

	private long id;
	private String nombreCurso;
	private String autor;
	
	public Curso(long id, String nombreCurso, String autor) {
		super();
		this.id = id;
		this.nombreCurso = nombreCurso;
		this.autor = autor;
	}

	public long getId() {
		return id;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public String getAutor() {
		return autor;
	}

	public String toString() {
		return "Curso [id=" + id + ", nombreCurso=" + nombreCurso + ", autor=" + autor + "]";
	}
}
