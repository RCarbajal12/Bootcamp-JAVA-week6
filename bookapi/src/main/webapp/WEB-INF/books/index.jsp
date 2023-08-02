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
<title>Libros</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>

<body>
	<div class="p-3 mb-2 bg-light text-black">
		<h1 class="container mx-auto m-3 p-3 text-center">ALL BOOKS</h1>
		<table class="table table-striped table-primary">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Title</th>
					<th scope="col">Description</th>
					<th scope="col">Language</th>
					<th scope="col">Number of Pages</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.description}" /></td>
						<td><c:out value="${book.language}" /></td>
						<td><c:out value="${book.numberOfPages}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/books/new" class="link-dark link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">New Book</a>
	</div>

</body>
</html>