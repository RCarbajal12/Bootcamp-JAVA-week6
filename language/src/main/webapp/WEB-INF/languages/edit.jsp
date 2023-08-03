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
<title>Java</title>
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<a href="/languages" class="btn btn-success m-3">Dashboard</a>
<div class="container p-3 mb-2 bg-light text-center">
<h1 class="m-3 p-3">Edit Languages</h1>
<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put">
    <div>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input class="form-control" path="name"/>
    </div>
    <div>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea class="form-control" path="creator"/>
    </div>
    <div>
        <form:label path="numberOfVersion">Version</form:label>
        <form:errors path="numberOfVersion"/>
        <form:input class="form-control" path="numberOfVersion"/>
    </div>    
    <input type="submit" value="Submit" class="btn btn-primary m-3"/>
</form:form>
</div>

</body>
</html>