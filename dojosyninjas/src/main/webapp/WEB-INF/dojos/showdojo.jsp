<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formateo fechas (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formulario form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MOSTRAR DOJO</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

<div class="container border rounded-lg p-4 mt-4 bg-success p-2 text-dark bg-opacity-10">
		<h1 class="text-center display-4 m-3">
			Bienvenido a
			<c:out value="${dojo.name }"></c:out>
			Ninjas
		</h1>

		<table class="table table-hover ">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojo.ninjas }" var="ninja">
					<tr>
						<td><c:out value="${ninja.firstName}"></c:out></td>
						<td><c:out value="${ninja.lastName }"></c:out></td>
						<td> <c:out value="${ninja.age }"></c:out></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/" class="btn btn-success m-3">Go back</a>
	</div>


</body>
</html>