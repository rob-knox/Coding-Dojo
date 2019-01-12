<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Roster</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div class="container">
		<h1>All Students</h1>
		<a class="new" href="/students/new">New Student</a> <a class="new" href="/dorms/new">New Dormitory</a>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></td>
					<td><c:out value="${student.age}"/></td>
					<td><c:out value="${student.address.street}"/></td>
					<td><c:out value="${student.address.city}"/></td>
					<td><c:out value="${student.address.state}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>