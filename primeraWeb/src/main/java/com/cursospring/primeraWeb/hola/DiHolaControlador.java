package com.cursospring.primeraWeb.hola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Spring crea un Bean de esta clase, que estamos indicando que incluye métodos que son requests (peticiones HTTP)
public class DiHolaControlador {

	//    http://localhost:8080/di-hola   
    @RequestMapping("/di-hola") // la barra '/' se puede poner o NO sin problema
    @ResponseBody //Hay que usarlo para que el navegador lo distinga de una vista. Más adelante, cuando envíes una vista JSP, lo entenderás.
    public String saluda() {
        return "Hola desde una request que devuelve un String sin más. Mira, no hay título en la web.";
    }
    
    //    http://localhost:8080/di-hola-en-html
    @RequestMapping("di-hola-en-html")
    @ResponseBody 
    public String saludaEnHtml() {
    	StringBuffer stringBuffer = new StringBuffer();
    	
    	stringBuffer.append("<HTML>")
		    	.append("<HEAD>")
		    	.append("<TITLE>Título en la etiqueta TITLE</TITLE>")
		    	.append("</HEAD>")
		    	.append("<BODY>Mensaje dentro de la etiqueta BODY.</BODY>")
		    	.append("</HTML>");
    	
        return stringBuffer.toString();
    }
    /* Como esto de arriba -saludaEnHtml()- es insostenible porque no vamos a estar escribiendo todo el HTML desde el servidor,
     * en vez de usar este método de envío de todo el código HTML, usaremos lo que se llama JSP -> Java Server Pages 
     * y enviar la vista. Para ello, hemos de añadir esta dependencia en el pom.xml:
      
     <dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
		<scope>provided</scope>
	 </dependency>
		 
	 * En JSP, una vista es un archivo .jsp que se encarga de la presentación de la información en una aplicación web. 
	 * Es el componente que genera la respuesta HTML que el usuario verá en su navegador.
	 * Se ubica en WEB-INF/jsp/    y se llama diHola.jsp	
	 * Hay que añadir la ruta ya pasado /src/main/webapp (que es donde hay que ubicar la carpeta)y la extensión en el properties. 
     */
    
//  http://localhost:8080/di-hola-en-jsp
  @RequestMapping("di-hola-en-jsp")
  public String saludaEnJsp() {
      return "diHola"; // Este es el nombre de la vista .jsp que se va a devolver a Spring Web (MVC), que lo va a buscar en la ruta y con la extensión especificadas en el properties 
  }
}
