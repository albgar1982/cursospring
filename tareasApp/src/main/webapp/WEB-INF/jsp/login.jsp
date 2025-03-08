<html lang="es">
	<head>
	    <title>Login B�sico</title>
	</head>
	<body>
	<div class="container"> <!-- Para Bootstrap -->
		<h2>Inicie Sesi�n</h2>
	    <pre>${errorDeAutenticacion}</pre>
	    <form method="post"> <!-- Si no especificamos este atributo, la info se enviar� en la URL como requestParams, y usando el m�todo por defecto, que es GET. As�, la info se env�a en el payload del m�todo POST y Spring enrutar� correctamente al endpoint POST-->
	        <label for="nombre">Usuario:</label><br>
	        <input type="text" id="nombre" name="nombre" ><br><br>
	
	        <label for="contrasenia">Contrase�a:</label><br>
	        <input type="password" id="contrasenia" name="contrasenia" ><br><br>
	
	        <button type="submit">ENTRAR</button>
	    </form>
	</div>
	    
	
	</body>
</html>