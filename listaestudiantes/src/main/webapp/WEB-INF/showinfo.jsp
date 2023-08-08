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
<title>ESTUDIANTES</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<br>
	<br>
	<div class="container mt-4 border rounded-lg p-4 mt-4 bg-primary p-2 text-dark bg-opacity-50">
		<h1 class="mb-4 text-center display-3 text-white">Bienvenidos a la Lista de Estudiantes</h1>
		<div class="mb-5 text-center">
			<a href="/students/new" class="btn btn-primary">Agrega una nuevo estudiante</a>
			<a href="/contact/new" class="btn btn-primary">Agrega una nueva informacion de contacto</a>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${todos}" var="estudiante">
					<tr>
						<td>${estudiante.firstName} ${estudiante.lastName}</td>
						<td>${estudiante.age}</td>
						<td>${estudiante.getContactmodel().getAddress()}</td>
						<td>${estudiante.getContactmodel().getCity()}</td>
						<td>${estudiante.getContactmodel().getState()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>