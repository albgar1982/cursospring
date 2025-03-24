<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="comunes/header.jspf" %> <!-- Incluimos el header  -->
<%@ include file="comunes/barraNavegacion.jspf" %>	<!-- Incluimos la barra de navegación -->
<div class="container">
    <h2>Nueva Tarea</h2>
    <form:form method="post" modelAttribute="tarea"> <!-- modelAttribute="tarea" es el nombre que le hemos dado al objeto que vamos a enviar al controlador, en el que hay que usar @ModelAttribute("tareita") para que Spring sepa de que le hablamos -->

	    <fieldset class="mb-3"> <!-- Etiqueta para agrupar info de un mismo elemento.  -->
		    <form:label path="descripcion">Descripción</form:label>
		    <form:input type="text" path="descripcion" required="required" /> <!-- required="required" hace que no puedan dejar la casilla vacia. Es un control desde el front. Mejor que esto, vamos a poner validaciones desde el back -->
	    	<form:errors path="descripcion" cssClass="text-warning"/> <!-- Aqui se mostraran los mensajes de error que se generen en el controlador -->
	    </fieldset>
	    
	    <small class="form-text text-muted">Formato: aaaa/mm/dd</small> <!-- Aniadimos un texto de ayuda para el formato de la fecha-->
         
		<fieldset class="mb-3">
			<form:label path="fechaObjetivo">Fecha Fin</form:label> <!-- path="fechaObjetivo" es el nombre del atributo de la clase Tarea que estamos mapeando. Tienen que coincidir los nombres o fallara. Aqui y en todos los campos-->
			<form:input type="text" path="fechaObjetivo" required="required" /> <!-- Chrome muestra automaticamente un selector de fecha si usas <input type="date"> dentro de un <form>. No necesitas agregar nada mas para que funcione. Si le pones text, no saca el calendario. -->
			<form:errors path="fechaObjetivo" cssClass="text-warning" />
		</fieldset>
		
		<!-- Estos campos no se muestran en el formulario, pero se envian al controlador -->
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="hecho" />
		<!-- Botón de envío de info -->
		<input type="submit" value="A&ntilde;adir" class="btn btn-success">
	</form:form>
</div>

<%@ include file="comunes/footer.jspf" %> <!-- Incluimos el footer -->

<script>
	$(document).ready(function() {
	     $('#fechaObjetivo').datepicker({
	         format: 'yyyy-mm-dd',
	         startDate: '+1d',
	         language: 'es',
	         defaultViewDate: 'today'
	     });
	 });
</script>