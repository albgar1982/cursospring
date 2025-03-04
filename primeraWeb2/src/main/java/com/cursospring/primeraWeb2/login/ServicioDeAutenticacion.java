package com.cursospring.primeraWeb2.login;

import org.springframework.stereotype.Service;

@Service //Contiene lógica y queremos que se cree un Bean
public class ServicioDeAutenticacion {

	private final String usuarioCorrecto = "Alber";
	private final String contraseniaCorrecta = "Alber123";
	
	public boolean compruebaUsuarioYContrasenia(String usuario,String contrasenia) {
		
		return usuario.equals(usuarioCorrecto) && contrasenia.equals(contraseniaCorrecta);
	}
}
