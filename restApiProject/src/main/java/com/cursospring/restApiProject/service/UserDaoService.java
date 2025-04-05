package com.cursospring.restApiProject.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.cursospring.restApiProject.model.User;

@Component
public class UserDaoService {

	private static ArrayList<User> users = new ArrayList<>();
	private static int contadorUsuarios = 0;
	
	static {
		users.add(new User(++contadorUsuarios, "Alberto", LocalDate.of(1982, 4, 6)));
		users.add(new User(++contadorUsuarios, "Laura", LocalDate.of(1978, 6, 26)));
		users.add(new User(++contadorUsuarios, "Ernesto", LocalDate.of(1978, 6, 8)));
	}
	
	public ArrayList<User> findAll() {
		return users;
	}

	public User findUserById(int id) {
		Predicate<User> condicion = user -> user.getId().equals(id); //Condición: el usuario tiene que tener el id que se pasa por parámetro
		return users.stream().filter(condicion).findFirst().orElse(null); //Devuelve el primer usuario que cumpla la condición, si no hay ninguno, devuelve null
	}

	public User salvarUsuario(User usuario) {
		usuario.setId(++contadorUsuarios);
		users.add(usuario);
		return usuario;
	}

	public void deleteUserById(int id) {
		Predicate<User> condicion = user -> user.getId().equals(id);
		users.removeIf(condicion);
	}
}
