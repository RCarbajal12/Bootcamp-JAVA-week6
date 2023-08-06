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
<title>DOJOS Y NINJAS</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<div class="container border rounded-lg p-4 mt-4 bg-success p-2 text-dark bg-opacity-50">
		<h1 class="my-4 text-center text-light display-3">Bienvenidos Dojos y Ninjas</h1>
		<div class="container d-flex justify-content-center align-items-center">
			<a href="/dojo/new" class="btn btn-success m-3">Agregar un nuevo dojo</a>
			<a href="/ninja/new" class="btn btn-success m-3">Agregar un nuevo ninja</a>
		</div>
		<h3>Entrar a:</h3>
		<ul class="list-group mt-4">
			<c:forEach items="${dojos}" var="dojo">
				<li class="list-group-item">
					<a href="/dojo/${dojo.id}" class="text-dark">
						<c:out value="${dojo.name }"></c:out>
					</a>
				</li>
			</c:forEach>
			
		</ul>
	</div>
</body>
</html>