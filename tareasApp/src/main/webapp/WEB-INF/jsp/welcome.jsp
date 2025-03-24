<%@ include file="comunes/header.jspf" %> <!-- Incluimos el header  -->
<%@ include file="comunes/barraNavegacion.jspf" %>	<!-- Incluimos la barra de navegacion -->
		
<div class="container"> <!-- Para Bootstrap -->
    <h2>Bienvenido/a, ${nom}</h2>
    <a href="tareas">Ir a listado de tareas</a> <!-- href="tareas" coincide con el nombre del endpoint -->
</div>
	    
<%@ include file="comunes/footer.jspf" %> <!-- Incluimos el footer -->

<!-- La etiqueta <a> sirve para crear texto pulsable con un enlace a otra pagina. En este caso, el atributo href indica el endpoint al que redirigimos el flujo de ejecucion -->