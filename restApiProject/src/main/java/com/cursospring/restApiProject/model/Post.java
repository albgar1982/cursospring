package com.cursospring.restApiProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

//Jackson usa reflection para acceder a los campos. Si no hay getters, no serializa.
@Data // Provee de los getters y setters y el método toString
@NoArgsConstructor // Constructor sin args (requerido por JPA y Jackson)
@Entity(name = "publicaciones") 
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 10, message = "El mensaje debe tener al menos 10 caracteres") // Validación del tamaño del mensaje
	private String mensaje;
	
	@ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno con User. La carga se hace de forma perezosa (lazy), es decir, solo se carga cuando se necesita
	@JsonIgnore // Evitamos que se produzca un bucle infinito al serializar el objeto
	private UserJpa usuario; //Si cambiamos el nombre de la columna con @Column(name = "lo_que_sea") -> ponemos en el insert lo_que_sea.
	// Si no, lo que se guarda en la base de datos es el id del usuario, no el objeto UserJpa, con lo que el insert ha de ser como ves en el data.sql, usando USUARIO_ID
}