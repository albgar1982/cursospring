<html lang="es">
	<head>
	    <title>Login Básico</title>
	</head>
	<body>
	<div class="container"> <!-- Para Bootstrap -->
		<h2>Inicie Sesión</h2>
	    <pre>${errorDeAutenticacion}</pre>
	    <form method="post"> <!-- Si no especificamos este atributo, la info se enviará en la URL como requestParams, y usando el método por defecto, que es GET. Así, la info se envía en el payload del método POST y Spring enrutará correctamente al endpoint POST-->
	        <label for="nombre">Usuario:</label><br>
	        <input type="text" id="nombre" name="nombre" ><br><br>
	
	        <label for="contrasenia">Contraseña:</label><br>
	        <input type="password" id="contrasenia" name="contrasenia" ><br><br>
	
	        <button type="submit">ENTRAR</button>
	    </form>
	</div>
	    
	
	</body>
</html>