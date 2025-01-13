<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tu signo chino</title>
</head>
<body>
<%
    String signo = (String) request.getAttribute("signoChino");
%>
<h2>Tu signo del horóscopo chino es: <%= signo != null ? signo : "" %></h2>

<a href="menu.jsp">Volver al Menú</a>
</body>
</html>
