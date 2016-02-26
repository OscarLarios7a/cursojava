<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		Saldo:${requestScope.saldo}
		<br/>
		<table>
			<tr><th>Tipo</th>
				<th>Cantidad</th>
				<th>Fecha</th>
			</tr>
			<c:forEach var="m" items="${requestScope.movimientos}">
				<tr>
					<td>${m.operacion}</td>
					<td>${m.cantidad}</td>
					<td>${m.fecha}</td>
				</tr>
			
			</c:forEach>
		
		
		
		
		</table>
	<br/>
	<a href="toOperaciones">Inicio</a>
	</center>
	
</body>
</html>