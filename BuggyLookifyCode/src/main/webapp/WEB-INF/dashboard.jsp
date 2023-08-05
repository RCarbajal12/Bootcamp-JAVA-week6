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
<title>Lookify!</title>
</head>
<body>
<br>
<div class="container mt-4">
<h1 class="m-5">All Songs</h1>
        <div class="row mb-3">
            <div class="col">
                <a class="btn btn-primary" href="/songs/new">Add New</a>
            </div>
            <div class="col">
                <a class="btn btn-primary" href="/top-ten">Top Ten</a>
            </div>
            <div class="col">
                <form class="form-inline" action="/search" method="get">
                    <div class="input-group">
                        <input class="form-control mr-2" type="text" id="artist" name="q" placeholder="Search artist" />
                        <div class="input-group-append">
                            <input class="btn btn-outline-primary" type="submit" value="Submit" />
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <hr>
        <table class="table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Rating</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="song" items="${songs}">
                    <tr>
                        <td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
                        <td><c:out value="${song.rating}"></c:out></td>
                        <td><a class="btn btn-danger" href="/songs/${song.id}/delete">delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>