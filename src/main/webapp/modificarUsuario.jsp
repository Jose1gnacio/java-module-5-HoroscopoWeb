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
    <title>Modificar Usuario</title>
</head>
<body>
<h1>Modificar Datos</h1>
<form action="modificar" method="post">
    <label>Nombre:</label>
    <input type="text" name="nombre" value="<%=user.getNombre()%>"><br><br>
    
    <label>Usuario:</label>
    <input type="text" name="usuario" value="<%=user.getUsuario()%>" readonly><br><br>
    
    <label>Email:</label>
    <input type="email" name="email" value="<%=user.getEmail()%>"><br><br>
    
    <label>Fecha Nacimiento:</label>
    <input type="date" name="fechaNac" 
           value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(user.getFechaNacimiento()) %>"><br><br>
    
    <label>Password:</label>
    <input type="password" name="password" value="<%=user.getPassword()%>"><br><br>
    
    <label>Animal:</label>
    <input type="text" name="animal" value="<%=user.getAnimalHoroscopo()%>"><br><br>

    <button type="submit">Modificar</button>
</form>

<p style="color:blue;">
    <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %>
</p>
<a href="menu.jsp">Volver al Menú</a>
</body>
</html>
