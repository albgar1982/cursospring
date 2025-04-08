package com.cursospring.restApiProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus( code = HttpStatus.NOT_FOUND) //Devuelve un 404 Not Found
public class UserNotFoundException extends RuntimeException { 

	public UserNotFoundException(String message) {
		super(message);
	}
}
/*
 * La anotación @ResponseStatus indica a Spring que cuando se lance la excepción UserNotFoundException, devuelva un 404 Not Found.
 * La clase extiende de RuntimeException, por lo que NO es necesario capturarla en un try-catch, ya que Spring la captura automáticamente.
 * En el properties desactivamos el trace en todas las respuestas de error con
 * server.error.include-stacktrace=never
 * Hemos quitado devTools para que no envíe tanta info en las respuestas de error
 */