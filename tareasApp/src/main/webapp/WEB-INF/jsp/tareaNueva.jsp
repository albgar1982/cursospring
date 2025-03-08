<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form method="post">
            <div class="mb-3"> <!-- margin bottom 3 dejará un margen debajo del div de 3 pixels -->
                <label for="descripcion" class="form-label">Descripción:</label>
                <input type="text" name="descripcion" id="descripcion" class="form-control">
            </div>
            <input type="submit" value="Añadir" class="btn btn-success">
        </form>
    </div>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>