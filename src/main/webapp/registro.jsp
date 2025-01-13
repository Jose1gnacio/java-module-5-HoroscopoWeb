<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
</head>
<body>
    <h1>Registro</h1>
    <form action="registro" method="post">
        <label>Nombre:</label>
        <input type="text" name="nombre" required><br><br>
        
        <label>Usuario:</label>
        <input type="text" name="usuario" required><br><br>
        
        <label>Email:</label>
        <input type="email" name="email" required><br><br>
        
        <label>Fecha Nacimiento:</label>
        <input type="date" name="fechaNac" required><br><br>
        
        <label>Password:</label>
        <input type="password" name="password" required><br><br>
        
        <button type="submit">Registrar</button>
    </form>

    <p style="color:blue;">
        <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %>
    </p>
    
    <a href="login.jsp">Volver al login</a>
</body>
</html>
