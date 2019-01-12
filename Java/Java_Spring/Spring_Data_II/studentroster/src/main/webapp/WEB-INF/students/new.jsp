<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Roster</title>
</head>
<body>
	<div class="container">
		<h1>New Student</h1>
		<form:form action="/students" method="post" modelAttribute="studentObj">
		<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName"/><form:errors path="firstName"/></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName"/><form:errors path="firstName"/></td>
			</tr>
			<tr>
				<td><form:label path="age">Age</form:label></td>
				<td><form:input path="age"/><form:errors path="age"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create"/><a class="submitBtn" href="/students">Back</a></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>