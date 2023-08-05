<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Add Song</title>
</head>
<body>

<form:form action="/songs/new" method="post" modelAttribute="song">


<div class="container mt-4 bg-light">
        <div class="row mb-3">
            <div class="col">
                <span class="d-flex justify-content-end m-2"><a href="/dashboard">Dashboard</a></span>
                <h1 class="float-left text-center">ADD SONG</h1>
            </div>
        </div>
        <form action="/songs/new" method="post" modelAttribute="song">
            <table class="table">
                <thead>
                    <tr>
                        <td class="bg-green">Title:</td>
                        <td>
                            <form:errors path="title" class="text-danger" />
                            <form:input class="form-control" path="title" />
                        </td>
                    </tr>
                    <tr>
                        <td>Artist:</td>
                        <td>
                            <form:errors path="artist" class="text-danger" />
                            <form:input class="form-control" path="artist" />
                        </td>
                    </tr>
                    <tr>
                        <td>Rating (1-10):</td>
                        <td>
                            <form:errors path="rating" class="text-danger" />
                            <form:input class="form-control" type="number" path="rating" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input class="btn btn-dark" type="submit" value="Add Song" /></td>
                    </tr>
                </thead>
            </table>
        </form>
    </div>
	
	

</form:form>
</body>
</html>