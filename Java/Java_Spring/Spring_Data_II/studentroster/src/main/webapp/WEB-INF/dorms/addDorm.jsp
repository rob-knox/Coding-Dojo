<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Dormitory</title>
</head>
<body>
	<h1>Dormitories</h1>
	<form:form action="/newDorm" method="post" modelAttribute="dormitoryObj">
		<form:label path="name">Name</form:label>
		<form:input path="name" /><form:errors path="name"/>
		<input type="submit" value="Create">
	</form:form>
	<a href="/students">Back</a>
</body>
</html>