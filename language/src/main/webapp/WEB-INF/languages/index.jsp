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
<title>Languages</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="p-3 mb-2 bg-light text-black">
		<h1 class="container mx-auto m-3 p-3 text-center">ALL LANGUAGES</h1>
		<table class="table table-striped table-primary">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Creator</th>
					<th scope="col">Version</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">
					<tr>
						<td><a href="/languages/${language.id}">${language.name}</a></td>
						<td><c:out value="${language.creator}" /></td>
						<td><c:out value="${language.numberOfVersion}" /></td>
						<td class="align-middle">
							<a href="/languages/${language.id}/edit" class="d-inline">Editar</a>
							<form action="/languages/${language.id}" method="post" class="d-inline">
								<input type="hidden" name="_method" value="delete"/>
								<input type="submit" class="btn btn-link mb-1" value="Borrar libro"/>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container p-3 mb-2 bg-light text-center">
	<h1 class="m-3 p-3">New Language</h1>
	<form:form action="/languages" method="post" modelAttribute="language" class="mx-auto">
		<div class="form-group">
			<label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" />
            <form:errors class="text-danger" path="name" />
		</div>
		<div class="form-group">
			<label for="creator">Creator</label>
            <textarea class="form-control" id="creator" name="creator"></textarea>
            <form:errors class="text-danger" path="creator" />
		</div>
		<div class="form-group">
			 <label for="numberOfVersion">Version</label>
             <input type="text" class="form-control" id="numberOfVersion" name="numberOfVersion" />
             <form:errors class="text-danger" path="numberOfVersion" />
		</div>
		<input type="submit" value="Submit" class="btn btn-primary m-3"/>
	</form:form>
</div>
	

</body>
</html>