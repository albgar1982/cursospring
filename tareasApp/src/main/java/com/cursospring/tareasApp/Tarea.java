package com.cursospring.tareasApp;

import java.time.LocalDate;

public class Tarea {

	private int id;
	private String nombreUsuario;
	private String descripcion;
	private LocalDate fechaObjetivo;
	private boolean hecho;
	
	public Tarea(int id, String nombreUsuario, String descripcion, LocalDate fechaObjetivo, boolean hecho) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.descripcion = descripcion;
		this.fechaObjetivo = fechaObjetivo;
		this.hecho = hecho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaObjetivo() {
		return fechaObjetivo;
	}

	public void setFechaObjetivo(LocalDate fechaObjetivo) {
		this.fechaObjetivo = fechaObjetivo;
	}

	public boolean isHecho() {
		return hecho;
	}

	public void setHecho(boolean hecho) {
		this.hecho = hecho;
	}

	@Override
	public String toString() {
		return "Tareas [id=" + id + ", nombreUsuario=" + nombreUsuario + ", descripcion=" + descripcion
				+ ", fechaObjetivo=" + fechaObjetivo + ", hecho=" + hecho + "]";
	}
}
