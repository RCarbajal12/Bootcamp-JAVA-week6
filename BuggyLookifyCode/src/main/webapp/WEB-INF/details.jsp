<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Song Info</title>
</head>
<body>
<br>
<br>

<p class="d-flex justify-content-end m-2"><a href="/dashboard">Dashboard</a></p>
<div class="in-line">
	<h1 class="float-left">Song Info</h1>
</div>
	<hr>
	<div class="container mt-4">
   <div class="row">
        <div class="col">
            <table class="table table-striped">
                <tr>
                    <th>Title:</th>
                    <td><c:out value="${song.title}"></c:out></td>
                </tr>
                <tr>
                    <th>Artist:</th>
                    <td><c:out value="${song.artist}"></c:out></td>
                </tr>
                <tr>
                    <th>Rating (1-10):</th>
                    <td><c:out value="${song.rating}"></c:out></td>
                </tr>
            </table>
        </div>
        </div>
        <div class="row">
        <div class="col">
            <a href="/songs/${song.id}/delete" class="btn btn-danger">Delete</a>
        </div>
    </div>
</div>
</body>
</html>