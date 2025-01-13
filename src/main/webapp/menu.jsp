<%@ page import="com.horoscopo.modelo.Usuario" %>
<%
    // Verificar que existe la sesión
    HttpSession miSession = request.getSession(false);
    if(session == null || session.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    Usuario user = (Usuario) session.getAttribute("usuarioLogueado");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Menú Principal</title>
</head>
<body>
    <h2>Bienvenido/a <%= user.getNombre() %>!</h2>
    
    <ul>
        <li><a href="consultarSigno">Conocer tu signo zodiacal chino</a></li>
        <li><a href="buscarUsuario.jsp">Búsqueda de usuarios</a></li>
        <li><a href="modificarUsuario.jsp">Modificar mi usuario</a></li>
        <li><a href="eliminarUsuario.jsp">Eliminar mi usuario</a></li>
    </ul>
    <br>
    <a href="login.jsp">Cerrar Sesión (manualmente, no hay seguridad configurada)</a>
</body>
</html>
