package com.cursospring.restApiProject.controller;

import java.net.URI;
import java.util.ArrayList;

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

import com.cursospring.restApiProject.exception.UserNotFoundException;
import com.cursospring.restApiProject.model.User;
import com.cursospring.restApiProject.service.UserDaoService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserDaoService service;
	
	//Constructor, para que Spring inyecte el servicio
	public UserController(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public ArrayList<User> devuelveTodosLosUsuarios() {
		return service.findAll();
	}
	
	/* Forma sencilla de devolver un usuario por id
	@GetMapping("/users/{id}")
	public User devuelveUsuarioPorId(@PathVariable int id) {
		return service.findUserById(id);
	}
	*/

	//Si el recurso solicitado no existe en el servidor -> 404 Not Found
	@GetMapping("/users/{id}")
	public EntityModel<User> devuelveUsuarioPorId(@PathVariable int id) { //EntityModel<User> permite añadir enlaces HATEOAS (lee en los apuntes sobr ello)
		User usuario = service.findUserById(id);
		//Si el usuario no existe, lanzamos una excepción
		if (usuario == null) {
			throw new UserNotFoundException("id no encontrado: " + id);
		}
		
		//Creamos un EntityModel con el usuario encontrado
		EntityModel<User> modelo = EntityModel.of(usuario);
		
		//Creamos un enlace HATEOAS al recurso devuelveTodosLosUsuarios() 
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).devuelveTodosLosUsuarios());
		//Añadimos el enlace HATEOAS al modelo
		modelo.add(linkTo.withRel("todos-usuarios"));
		return modelo;
	}
	
	/* Forma de devolver un usuario por id
	@PostMapping("/users")
	public User devuelveUsuarioPorId(@RequestBody User usuario) { 
		return service.salvarUsuario(usuario);
	}
	*/
	
	//Con @Valid indicamos que el usuario debe cumplir las validaciones que se hayan definido en la clase User
	@PostMapping("/users")
	public ResponseEntity<User> creaUsuario(@RequestBody @Valid User usuario) { //Con @RequestBody indicamos que el usuario viene en el cuerpo de la petición
		 User usuarioSalvado = service.salvarUsuario(usuario);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest() //Obtiene la URL actual http://localhost:8080/users
				 .path("/{id}") //Añade /id a la URL actual
				 .buildAndExpand( usuarioSalvado.getId() ) //Añade el id del usuario salvado a la URL
				 .toUri(); //Construye la URL de la respuesta 
		 return ResponseEntity.created(location).build(); //Construye una respuesta 201 Created con la URL de la respuesta
	}
	
	@DeleteMapping("/users/{id}")
	public void borraUsuarioPorId(@PathVariable int id) {
		service.deleteUserById(id); 
	}
}
