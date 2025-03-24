<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="comunes/header.jspf" %> <!-- Incluimos el header  -->
<%@ include file="comunes/barraNavegacion.jspf" %>	<!-- Incluimos la barra de navegacion -->
		
<div class="container"> <!-- Con Bootstrap es una buena practica meter todo el contenido del body dentro de una division con class="container" -->
	<h2>Tus tareas, ${nom}</h2>
    <hr>
    <div>
	    <table class="table"> <!-- Este atributo hace que Bootstrap lo ponga mas bonito -->
			  <tr>
				    <th>Usuario</th>
				    <th>Tarea</th>
				    <th>Fecha Objetivo</th>
				    <th>Realizada</th>
				    <th></th>
				    <th></th>
			  </tr>
			  <c:forEach items="${tareas}" var="tarea">
				  <tr>
					    <td>${tarea.nombreUsuario}</td>
					    <td>${tarea.descripcion}</td>
					    <td>${tarea.fechaObjetivo}</td>
					    <td>${tarea.hecho}</td>
					    <td> <a href="actualizar-tarea?id=${tarea.id}" class="btn btn-success">Actualizar</a></td>
					    <td> <a href="borrar-tarea?id=${tarea.id}" class="btn btn-warning">Borrar</a></td>
		  		  </tr>
			  </c:forEach>
		</table>
		<a href="nueva-tarea" class="btn btn-success">Añade Tarea</a> <!-- class="btn btn-success" es para Bootstrap. btn-success le da el color verde y los bordes redondeados -->
    </div>
</div>
   
<%@ include file="comunes/footer.jspf" %> <!-- Incluimos el footer -->