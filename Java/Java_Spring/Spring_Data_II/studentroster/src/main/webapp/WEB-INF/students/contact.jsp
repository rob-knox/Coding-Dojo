<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Roster</title>
</head>
<body>
	<div class="container">
		<h1>Contact Info</h1>
		<form:form action="/contact" method="post" modelAttribute="addressObj">
		<table>
			<tr>
				<td><form:label path="student">Student</form:label></td>
				<td>
				<form:select path="student"><form:errors path="student"/>
					<c:forEach items="${allStudents}" var="student">
						<form:option value="${student.id}"> ${student.firstName}</form:option>
					</c:forEach>
				</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="street">Street</form:label></td>
				<td><form:input path="street"/><form:errors path="street"/></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:input path="city"/><form:errors path="city"/></td>
			</tr>
			<tr>
				<td><form:label path="state">state</form:label></td>
				<td><form:input path="state"/><form:errors path="state"/></td>
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