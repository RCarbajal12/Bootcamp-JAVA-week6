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
<title>Crea tu libro</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="container p-3 mb-2 bg-light text-center">
	<h1 class="m-3 p-3">New Book</h1>
	<form:form action="/books" method="post" modelAttribute="libro" class="mx-auto">
		<div class="form-group">
			<label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title" />
            <form:errors class="text-danger" path="title" />
		</div>
		<div class="form-group">
			<label for="description">Description</label>
            <textarea class="form-control" id="description" name="description"></textarea>
            <form:errors class="text-danger" path="description" />
		</div>
		<div class="form-group">
			<label for="language">Language</label>
            <input type="text" class="form-control" id="language" name="language"/>
            <form:errors class="text-danger" path="language" />      
		</div>
		<div class="form-group">
			 <label for="numberOfPages">Pages</label>
             <input type="number" class="form-control" id="numberOfPages" name="numberOfPages" />
             <form:errors class="text-danger" path="numberOfPages" />
		</div>
		<input type="submit" value="Submit" class="btn btn-primary m-3"/>
	</form:form>
</div>

</body>
</html>