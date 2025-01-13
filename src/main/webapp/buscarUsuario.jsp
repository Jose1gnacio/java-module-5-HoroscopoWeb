<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.horoscopo.modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Usuario</title>
</head>
<body>
<h1>Buscar Usuario</h1>
<form action="buscar" method="post">
    <label for="usuario">Ingrese username:</label>
    <input type="text" name="usuario" id="usuario">
    <button type="submit">Buscar</button>
</form>
<br>

<%
    Usuario u = (Usuario) request.getAttribute("usuarioEncontrado");
    if(u != null){
%>
    <p>Nombre: <%= u.getNombre() %></p>
    <p>Email: <%= u.getEmail() %></p>
    <p>Fecha de Nacimiento: <%= u.getFechaNacimiento() %></p>
    <p>Animal Horóscopo: <%= u.getAnimalHoroscopo() %></p>
<%
    }
%>

<p style="color:red;"><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></p>

<a href="menu.jsp">Volver al Menú</a>
</body>
</html>
