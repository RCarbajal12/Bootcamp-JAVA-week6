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
<title>NUEVO NINJA</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

<div class="container mx-auto col-3 m-3 bg-success p-2 text-dark bg-opacity-25">
		<h1 class="display-4">Nuevo Ninja</h1>
		<form:form action="/ninja/new" method="POST" modelAttribute="ninjaform">
			<div class="form-group">
			<form:label class="form-label m-2" path="dojo">Seleccionar Dojo: </form:label>
				<form:select class="form-control " path="dojo">
					<c:forEach items="${dojos}" var="dojo">
						<form:option value="${dojo.id }">${dojo.name }</form:option>

					</c:forEach>

				</form:select>

			</div>
			<div class="form-group">
				<form:label class="form-label" path="firstName">Name:  </form:label>
				<form:errors class="text-danger" path="firstName" />
				<form:input type="text" class="form-control" path="firstName" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="lastName">Last Name: </form:label>
				<form:errors class="text-danger" path="lastName" />
				<form:input type="text" class="form-control" path="lastName" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="age">Age </form:label>
				<form:errors class="text-danger" path="age" />
				<form:input type="number" class="form-control" path="age" />
			</div>
			<button class="btn btn-success m-3">Create Ninja</button>
		</form:form>
	</div>


</body>
</html>