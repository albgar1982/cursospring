package com.cursospring.ejercicio18;

public class Curso {

	private long id;
	private String curso;
	private String autor;
	
	public Curso() {
		super();
	}
	
	public Curso(long id, String curso, String autor) {
		super();
		this.id = id;
		this.curso = curso;
		this.autor = autor;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", curso=" + curso + ", autor=" + autor + "]";
	}	
}
