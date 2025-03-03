package com.cursospring.primeraWeb.login;

import java.util.HashMap;
import java.util.Map;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginControlador {
	
/* Me lo ahorro, uso @Slf4j de Lombok, que he incluído en el pom.xml
   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;
   private Logger logger = LoggerFactory.getLogger(getClass());
*/

  //http://localhost:8080/login
  @RequestMapping("login")
  public String irAPaginaDeLogin() {
      return "login";  
  }
  
  //http://localhost:8080/login-con-request-param?nombre=Alberto
  @RequestMapping("login-con-request-param")
  public String probandoRequestParam(@RequestParam String nombre, ModelMap modelo) { //@RequestParam indica que en la llamada va a llegar un parámetro con el tipo indicado (en este caso, texto, por eso usamos String, para que coincida el tipo)
	  log.debug("El nombre que nos llega es {}", nombre);
      modelo.put("name", nombre); //El ModelMap funciona como un mapa de clave/valor. Con su clave, accederemos al valor desde el .jsp Lee más en los apuntes
	  return "loginConRequestParam";  
  }
  
  //Este es un ejemplo hecho por mi cuenta para devolver en formato JSON, que no está en el curso
  @GetMapping(value = "/basic-json", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String getBasicJson() throws Exception {
      Map<String, String> json = new HashMap<String, String>();
      json.put("mensaje", "Hola desde Spring!");
      json.put("estado", "exito");

      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(json);
  }
  /*
   * produces = MediaType.APPLICATION_JSON_VALUE:
		Este atributo especifica el tipo de contenido (Content-Type) que el método del controlador producirá en la respuesta HTTP.
		En este caso concreto, indica que la respuesta será JSON (application/json).
		Spring utiliza este atributo para establecer el header Content-Type en la respuesta HTTP.
		Este header, el content-type, SE ENVÍA al front.
   */
}

