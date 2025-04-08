package com.cursospring.restApiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cursospring.restApiProject.model.UserJpa;

public interface UserRepository extends JpaRepository<UserJpa, Integer> {
    // Esta interfaz extiende JpaRepository, que ya tiene implementados los métodos CRUD (create, read, update, delete)
	// No es necesario añadir nada, ya que JpaRepository ya tiene los métodos necesarios para el CRUD
	// Podemos añadir métodos personalizados si lo deseamos. Por ejemplo, un método que busque usuarios por nombre:
	// List<User> findByName(String name);
}
