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
<title>NEW CONTACT</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="container p-5 border rounded-lg p-4 mt-4 bg-primary p-2 text-dark bg-opacity-10">
  <div class="row justify-content-center">
    <div class="col-md-6">
    
      <h1 class="text-center display-4">Contact Info</h1>
      <form:form action="/contact/new" method="POST" modelAttribute="contact">
      
        <div class="form-group">
          <form:label class="form-label" path="estudianteModel">Student:</form:label>
          <form:select class="form-control" path="estudianteModel">
            <c:forEach items="${estudiantes}" var="e">
              <form:option value="${e.id}">${e.firstName} ${e.lastName}</form:option>
            </c:forEach>
          </form:select>
        </div>
        
        <div class="form-group">
          <form:label class="form-label" path="address">Address:</form:label>
          <form:errors class="text-danger" path="address" />
          <form:input type="text" class="form-control" path="address" />
        </div>
        
        <div class="form-group">
          <form:label class="form-label" path="city">City:</form:label>
          <form:errors class="text-danger" path="city" />
          <form:input type="text" class="form-control" path="city" />
        </div>
        <div class="form-group">
          <form:label class="form-label" path="state">State:</form:label>
          <form:errors class="text-danger" path="state" />
          <form:input type="text" class="form-control" path="state" />
        </div>

        <div class="text-center">
          <button class="btn btn-primary m-3">Create</button>
        </div>
        
      </form:form>
    </div>
  </div>
</div>



</body>
</html>