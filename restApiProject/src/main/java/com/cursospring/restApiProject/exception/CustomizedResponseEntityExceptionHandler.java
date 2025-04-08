package com.cursospring.restApiProject.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
@ControllerAdvice //Para que sea global, aplica a todos los controladores
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{ //Clase propia que maneja las excepciones. Hereda de ResponseEntityExceptionHandler, que es una clase base de Spring diseñada para manejar excepciones comunes de Spring MVC                                                       
 
	@ExceptionHandler(Exception.class) //Captura cualquier excepción. Evidentemente, podemos recoger excepciones más específicas
	public final ResponseEntity<DetallesError> handleAllExceptions(Exception excepcion, WebRequest request) throws Exception {
		DetallesError errorDetails = new DetallesError(LocalDateTime.now(), excepcion.getMessage(), request.getDescription(false)); //false para no incluir la descripción del error
		
		return new ResponseEntity<DetallesError>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR); //500 Internal Server Error
	}
 
	//ResponseEntity<DetallesError>: Indica que este método siempre devuelve una respuesta HTTP cuyo body es un objeto DetallesError.
	@ExceptionHandler( { UserNotFoundException.class, PostNotFoundException.class } ) //Captura las excepciones de usuario y post no encontrados)
	public final ResponseEntity<DetallesError> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		DetallesError errorDetails = new DetallesError(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<DetallesError>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@Override //Sobreescribimos el método para personalizar el mensaje de error de validación de los campos
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatusCode status,WebRequest request) {

		//Cantidad de errores
		int cantidadDeErrores = ex.getBindingResult().getFieldErrorCount();
	    // Obtiene todos los errores de validación
	    String mensajesDeError = ex.getBindingResult().getFieldErrors().stream() //Obtenemos el flujo de errores
	            .map(error -> error.getField() + ": " + error.getDefaultMessage()) //Por cada error, obtenemos el campo y el mensaje
	            .collect(Collectors.joining(", ")); //Unimos los mensajes con una coma

	    String mensajeFinal = String.format("%d Errores de validación: %s",
	            cantidadDeErrores,
	            mensajesDeError);
	    
	    DetallesError errorDetails = new DetallesError(LocalDateTime.now(),mensajeFinal, request.getDescription(false));

	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}