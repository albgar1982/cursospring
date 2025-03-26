package com.cursospring.tareasApp;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;

/*
 * Para que las anotaciones de validación (como @Size) surtan efecto, hay que agregar la anotación @Valid al parámetro 
 * del controlador que recibe el objeto Tarea.
 * También se debe agregar un parámetro BindingResult para capturar los errores de validación.
 */
@Entity(name = "tareas") // Para que JPA sepa que esta clase es una entidad y que se debe mapear a una tabla de la base de datos. Con name se puede especificar el nombre de la tabla
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Para que el id se genere automáticamente en la base de datos (autoincremental sumando 1 cada vez)
	private int id;
	
	@Column(name = "nombre_usuario") // Para especificar el nombre de la columna en la base de datos
	private String nombreUsuario;
	
	@Size(min=5, message="La descripción debe tener al menos 5 caracteres") //Para validar la longitud de la descripción
	private String descripcion;
	
	@Future(message="La fecha tiene que ser mayor al día actual") //Para validar que la fecha objetivo sea futura
	@DateTimeFormat(pattern = "yyyy/MM/dd") // Indica el formato esperado
	@Column(name = "fecha_objetivo") // Para especificar el nombre de la columna en la base de datos
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

	public String toString() {
		return "Tareas [id=" + id + ", nombreUsuario=" + nombreUsuario + ", descripcion=" + descripcion
				+ ", fechaObjetivo=" + fechaObjetivo + ", hecho=" + hecho + "]";
	}
}
