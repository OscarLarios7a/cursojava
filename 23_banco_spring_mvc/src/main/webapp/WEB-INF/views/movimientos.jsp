<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<center>
		Saldo de la cuenta: ${requestScope.saldo}
		<h2>Listado de movimientos</h2>
		<table border="1">
			<tr>
				<th>Tipo</th>
				<th>Cantidad</th>
				<th>Fecha</th>
			</tr>
			<c:forEach var="mov" items="${requestScope.movimientos}">
				<tr>
					<td>${mov.operacion}</td>
					<td>${mov.cantidad}</td>
					<td>${mov.fecha}</td>
				</tr>
			</c:forEach>
		</table>
		<br /></br> <a href="toOperaciones">Volver</a>
	</center>
</body>
</html>