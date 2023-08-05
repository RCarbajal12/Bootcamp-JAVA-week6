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
<title>NEW PERSON</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h2 class="text-center">Nueva Persona</h2>
				<form:form action="/persons/new" method="POST" modelAttribute="persona">
					<div class="form-group">
						<form:label class="form-label" path="firstName">First Name:</form:label>
						<form:errors class="text-danger" path="firstName" />
						<form:input class="form-control" path="firstName" />
					</div>
					<div class="form-group">
						<form:label class="form-label" path="lastName">Last Name:</form:label>
						<form:errors class="text-danger" path="lastName" />
						<form:input class="form-control" path="lastName" />
					</div>
					<button class="btn btn-success m-3">Crear Persona</button>	
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>