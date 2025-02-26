package com.cursospring.ejercicio19.jpa;

import org.springframework.stereotype.Repository;

import com.cursospring.ejercicio19.entidad.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/*
 * El EntityManager en sí no maneja transacciones de forma automática, ya que, en el contexto de JPA, 
 * las transacciones son gestionadas por el contenedor de persistencia (en este caso, Spring), 
 * y no directamente por el EntityManager. Éste proporciona los métodos para interactuar con la base 
 * de datos (como merge, find, etc.), pero no maneja las transacciones a menos que se le indique explícitamente cómo hacerlo.
 * 
 * El EntityManager por sí solo no gestiona las transacciones. Si quieres que las operaciones de base
 * de datos sean transaccionales (es decir, que todas las operaciones dentro de un método se ejecuten
 * correctamente o se deshagan en caso de error), debes utilizar @Transactional en los métodos o en la
 * clase que esté realizando las operaciones de persistencia. Esto asegura que Spring administre la transacción correctamente.
 */

@Repository
@Transactional //Siempre que queramos usar un EntityManager, necesitaremos una transacción
public class CursoJpaRepositorio {

	@PersistenceContext //Inyecta el EntityManager. Más específico que @Autowired. Más info en los apuntes.
	private EntityManager entityManager;
	
	
	public void crearCurso(Curso curso) {
		entityManager.merge(curso);
	}
	
	public Curso encontrarCursoPorId(long id) {
		return entityManager.find(Curso.class, id);
	}
	
	public void eliminarCursoPorId(long id) {
		//Para eliminar una fila, primero hay que encontrarla.
		Curso curso = entityManager.find(Curso.class, id);
		entityManager.remove(curso);
	}
}
