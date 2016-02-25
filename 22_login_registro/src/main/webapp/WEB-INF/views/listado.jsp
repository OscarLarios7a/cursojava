<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	%>
<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<table border="1">
    <tr><th>Titulo</th><th>Autor</th><th>Precio</th></tr>
            <c:forEach var="lib" items="${requestScope.libros}">                
              	<td>${lib.titulo}</td>
				<td>${lib.autor}</td>
				<td>${lib.precio}</td></tr>        
            </c:forEach>
</table>
<br/></br>
	<a href="toLogin">Volver</a>
</body>
</html>