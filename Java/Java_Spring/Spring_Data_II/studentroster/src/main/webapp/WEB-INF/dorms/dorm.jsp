<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hugitout Dormitory</h1>
	<%-- <form:form action="assignStudent" method="post" modelAttribute="assignDormObj">
		<table>
			<tr>
				<td>
				<form:label path="student">Student</form:label>
				</td>
				<td>
				<form:select path="student"><form:errors path="student"/>
				<c:forEach items="${allStudents}" var="student">
					<form:option value="${student.id}"> ${student.firstName}</form:option>
				</c:forEach>
				</form:select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" class="submitButton"></td>
			</tr>
		</table>
	</form:form> --%>
	
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Action</th>
			</tr>
			<tr>
				<td></td>
				<td><a href="/remove">Remove</a></td>
			</tr>
		</thead>
	</table>
</body>
</html>