<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>AQUI EL TITULO DE TU PLANTILLA</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	  <div class="container p-3 mb-2 bg-light text-black">
        <h1 class="mb-4">
            <c:out value="${book.title}" />
        </h1>
        <div class="row">
            <div class="col-md-6">
                <p class="font-weight-bold fs-4">Description:</p>
                <p><c:out value="${book.description}" /></p>
                <p class="font-weight-bold fs-4">Language:</p>
                <p><c:out value="${book.language}" /></p>
                <p class="font-weight-bold fs-4">Number of pages:</p>
                <p><c:out value="${book.numberOfPages}" /></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <a href="/books/${book.id}/edit" class="btn btn-primary mr-2">Edit Book</a>
                <form action="/books/${book.id}" method="post" class="d-inline">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete" class="btn btn-danger">
                </form>
            </div>
        </div>
    </div>

</body>
</html>