package com.cursospring.restApiProject.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Provee de los getters y setters y el método toString
@AllArgsConstructor //Provee de un constructor con todos los argumentos
@Entity(name = "usuarios") //Especificamos otro nombre, ya que user es una palabra reservada, y, si no lo hacemos, nos dará un error
@NoArgsConstructor //Provee de un constructor sin argumentos, para que funcione el @Autowired en el constructor de UserJpaController
public class UserJpa {
	
	@Id //Especificamos que es la clave primaria
	@GeneratedValue //Genera el id automáticamente
	private Integer id;
	
	@Size(min = 2, message = "El nombre debe tener al menos 2 caracteres") //Validación del tamaño del nombre
	private String name;
	
	@Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual") //Validación de que la fecha de nacimiento sea anterior a la fecha actual
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "usuario") //Relación uno a muchos con la clase Post. El ATRIBUTO usuario de la clase Post es el que mapea la relación, no el nombre de la clase ni del Entity
	private List<Post> post; //Relación uno a muchos con la clase Post. Un usuario puede tener varios posts, pero un post solo puede tener un usuario.
}
