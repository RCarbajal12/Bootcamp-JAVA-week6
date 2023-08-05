<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRINCIPAL PAGE</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<br>
<br>
	<div class="container mt-4 ">
		<h1 class="mb-4 text-center">Bienvenidos a la Base de Datos de Licencia de Manejo</h1>
		<div class="mb-5 text-center">
			<a href="/persons/new" class="btn btn-primary">Agrega una nueva persona</a>
			<a href="/licencias/new" class="btn btn-primary">Agrega una nueva licencia</a>
		</div>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Numero Licencia</th>
					<th>Fecha Expiracion</th>
				</tr>

			</thead>
			<tbody>
				<c:forEach items="${todos }" var="persona">
					<tr>
						<td><a href="/licencias/${persona.id}">${persona.firstName }
								${persona.lastName }</a></td>
						<td>${persona.getLicencia().getNumberComoString() }</td>
						<td><fmt:formatDate pattern="MM/dd/yyy"
								value="${persona.getLicencia().getExpirationDate()}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>