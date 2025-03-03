<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Básico</title>
</head>
<body>

    <h2>Iniciar Sesión</h2>
    <form action="/login" method="post">
        <label for="username">Usuario:</label><br>
        <input type="text" id="username" name="username" placeholder="Ingrese usuario" autocomplete="off" required><br><br>

        <label for="password">Contraseña:</label><br>
        <input type="password" id="password" name="password" placeholder="Ingrese contraseña" autocomplete="new-password" required><br><br>

        <button type="submit">Iniciar Sesión</button>
    </form>

</body>
</html>