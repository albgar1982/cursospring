package com.cursospring.restApiProject.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cursospring.restApiProject.exception.PostNotFoundException;
import com.cursospring.restApiProject.exception.UserNotFoundException;
import com.cursospring.restApiProject.model.Post;
import com.cursospring.restApiProject.model.UserJpa;
import com.cursospring.restApiProject.repository.PostRepository;
import com.cursospring.restApiProject.repository.UserRepository;
import jakarta.validation.Valid;

@RestController
public class UserJpaController {

	private UserRepository userRepository;
	private PostRepository postRepository;
	
	//Constructor, para que Spring inyecte el UserRepository
	public UserJpaController(UserRepository userRepository,PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	

	//REQUESTS:
	
	//GET: Devuelve todos los usuarios
	@GetMapping("/jpa/users") //Nombre distinto para evitar conflictos con el método de la clase UserController
	public List<UserJpa> devuelveTodosLosUsuariosJpa() {
		return userRepository.findAll();
	}
	
	//GET: Devuelve un usuario por id
	@GetMapping("/jpa/users/{id}")
	public EntityModel<UserJpa> devuelveUsuarioJpaPorId(@PathVariable int id) { //EntityModel<User> permite añadir enlaces HATEOAS (lee en los apuntes sobr ello)
		//Buscamos el usuario por id. Puede que esté o puede que no, así que lo guardamos en un Optional
		Optional<UserJpa> usuarioOptional = userRepository.findById(id);
		//Si el usuario no existe, lanzamos una excepción
		if (usuarioOptional.isEmpty()) {
			throw new UserNotFoundException("id no encontrado: " + id);
		}
		
		//Creamos un EntityModel con el usuario encontrado (hay que hacer un get() para obtener el usuario del Optional)
		EntityModel<UserJpa> modelo = EntityModel.of(usuarioOptional.get());
		
		//Creamos un enlace HATEOAS al recurso devuelveTodosLosUsuarios() 
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).devuelveTodosLosUsuariosJpa());
		//Añadimos el enlace HATEOAS al modelo
		modelo.add(linkTo.withRel("todos-usuarios"));
		return modelo;
	}

	//DELETE: Elimina un usuario por id
	@DeleteMapping("/jpa/users/{id}")
	public void eliminaUsuarioJpaPorId(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	//POST: Crea un nuevo usuario
	@PostMapping("/jpa/users")
	public ResponseEntity<UserJpa> creaUsuarioJpa(@Valid @RequestBody UserJpa usuario) { // @Valid valida el usuario antes de
																					// guardarlo
		// Guardamos el usuario en la base de datos
		UserJpa usuarioGuardado = userRepository.save(usuario);

		// Creamos la URI del nuevo recurso
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioGuardado.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	/**
	 * Devuelve todos los posts de un usuario.
	 * @param id Id del usuario
	 * @return Lista de posts del usuario
	 */
	@GetMapping("/jpa/users/{id}/posts") 
	public List<Post> devuelveMensajesPorUsuario(@PathVariable int id) {
		//Buscamos el usuario por id. Puede que esté o puede que no, así que lo guardamos en un Optional
		Optional<UserJpa> usuarioOptional = userRepository.findById(id);
		//Si el usuario no existe, lanzamos una excepción
		if (usuarioOptional.isEmpty()) {
			throw new UserNotFoundException("No existe el usuario con id: " + id);
		}

		return usuarioOptional.get().getPost(); //Devolvemos la lista de posts del usuario.
	}
	
	/**
	 * Añade un nuevo post a un usuario.
	 * @param id Id del usuario
	 * @return El ResponseEntity con el nuevo post, con la URI del nuevo recurso
	 */
	@PostMapping("/jpa/users/{id}/posts") 
	public ResponseEntity<Post> aniadeMensajePorUsuarioId(@PathVariable int id,@RequestBody Post post) {
		//Buscamos el usuario por id. Puede que esté o puede que no, así que lo guardamos en un Optional
		Optional<UserJpa> usuarioOptional = userRepository.findById(id);
		//Si el usuario no existe, lanzamos una excepción
		if (usuarioOptional.isEmpty()) {
			throw new UserNotFoundException("No existe el usuario con id: " + id);
		}

		post.setUsuario(usuarioOptional.get()); //Asignamos el usuario al post
		Post postGuardado = postRepository.save(post); //Guardamos el post en la base de datos
		
		// Creamos la URI del nuevo recurso
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(postGuardado.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts/{postId}") 
	public Post devuelveMensajeDeUsuarioPorIdDeMensaje(@PathVariable int id,@PathVariable int postId) {
		//Buscamos el usuario por id. Puede que esté o puede que no, así que lo guardamos en un Optional
		Optional<UserJpa> usuarioOptional = userRepository.findById(id);
		//Si el usuario no existe, lanzamos una excepción
		if (usuarioOptional.isEmpty()) {
			throw new UserNotFoundException("No existe el usuario con id: " + id);
		}

		List<Post> listaPosts = usuarioOptional.get().getPost(); 
		
		Predicate<Post> predicado = post -> post.getId().equals(postId); //Creamos un predicado para filtrar la lista de posts por id
		return listaPosts.stream().filter(predicado).findFirst().orElseThrow( () -> new PostNotFoundException("No existe el mensaje con id: " + postId +" de ese usuario.") ); //Filtramos la lista de posts por id
	}
}

