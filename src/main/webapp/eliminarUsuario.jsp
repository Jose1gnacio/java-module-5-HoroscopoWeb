<%@ page import="com.horoscopo.modelo.Usuario" %>
<%
    HttpSession miSession = request.getSession(false);
    if(session == null || session.getAttribute("usuarioLogueado") == null){
        response.sendRedirect("login.jsp");
        return;
    }
    Usuario user = (Usuario) session.getAttribute("usuarioLogueado");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Eliminar Usuario</title>
</head>
<body>
<h1>Eliminar mi usuario</h1>
<p>Ten cuidado, esto no se puede deshacer</p>
<form action="eliminar" method="post">
    <label>Usuario:</label>
    <input type="text" name="usuario" value="<%=user.getUsuario()%>" readonly><br><br>
    
    <button type="submit">Eliminar</button>
</form>

<p style="color:red;">
    <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %>
</p>
<a href="menu.jsp">Volver al Menú</a>
</body>
</html>
