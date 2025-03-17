<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>ORGANIZADOR DE TAREAS</title>
</head>
<body>
    <div class="container">
        <h2>Nueva Tarea</h2>
        <form:form method="post" modelAttribute="tareita"> <!-- modelAttribute="tareita" es el nombre que le hemos dado al objeto que vamos a enviar al controlador, en el que hay que usar @ModelAttribute("tareita") para que Spring sepa de qu� le hablamos -->
            <label for="descripcion" class="form-label">Descripci�n:</label>
            <form:input type="text" path="descripcion" required="required" /> <!-- required="required" har� que no puedan dejar la casilla vac�a. Es un control desde el front. Mejor que esto, vamos a poner validaciones desde el back -->
           	<form:errors path="descripcion" cssClass="text-warning"/> <!-- Aqu� se mostrar�n los mensajes de error que se generen en el controlador -->
           	<form:input type="hidden" path="id" /> <!-- Este campo no se muestra en el formulario, pero se env�a al controlador -->
           	<form:input type="hidden" path="hecho" /> <!-- Este campo no se muestra en el formulario, pero se env�a al controlador -->
            <br><input type="submit" value="A�adir" class="btn btn-success">
        </form:form>
    </div>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>