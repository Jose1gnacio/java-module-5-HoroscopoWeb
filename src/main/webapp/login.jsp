<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="css/estilos.css" />
    <!-- O Bootstrap CDN -->
</head>
<body>
    <h1>Login</h1>
    <form action="login" method="post">
        <label for="usuario">Usuario:</label>
        <input type="text" name="usuario" id="usuario" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br><br>
        
        <button type="submit">Iniciar Sesión</button>
    </form>
    <br>
    <a href="registro.jsp">¿No tienes cuenta? Regístrate</a>

    <p style="color:red;">
        <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %>
    </p>
</body>
</html>
