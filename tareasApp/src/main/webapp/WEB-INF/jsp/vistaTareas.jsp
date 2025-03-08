<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"> <!-- Hoja de estilos -->
	    <title>ORGANIZADOR DE TAREAS</title>
	</head>
	<body>
	<div class="container"> <!-- Con Bootstrap es una buena práctica meter todo el contenido del body dentro de una división con class="container" -->
		<h2>Tus tareas, ${nom}</h2>
	    <hr>
	    <div>Las tareas son 
		    <table class="table"> <!-- Este atributo hace que Bootstrap lo ponga más bonito -->
				  <tr>
				    <th>Identificador</th>
				    <th>Usuario</th>
				    <th>Tarea</th>
				    <th>Fecha Objetivo</th>
				    <th>Realizada</th>
				  </tr>
				  <c:forEach items="${tareas}" var="tarea">
					  <tr>
					    <td>${tarea.id}</td>
					    <td>${tarea.nombreUsuario}</td>
					    <td>${tarea.descripcion}</td>
					    <td>${tarea.fechaObjetivo}</td>
					    <td>${tarea.hecho}</td>
			  		  </tr>
				  </c:forEach>
			</table>
			<a href="nueva-tarea" class="btn btn-success">Añade Tarea</a> <!-- class="btn btn-success" es para Bootstrap. btn-success le da el color verde y los bordes redondeados -->
	    </div>
	</div>
	    
	    <!-- En la etiqueta script incluimos el código JS -->
	    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>