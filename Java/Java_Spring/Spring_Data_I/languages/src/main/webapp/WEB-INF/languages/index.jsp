<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Languages</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="language">
			<tr>
				<td><a href='/languages/<c:out value="${language.id}" />'><c:out value="${language.name}"/></a></td>
				<td><c:out value="${language.creator}"/></td>
				<td><c:out value="${language.version}"/></td>
				<td>
				<form action="/languages/${language.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="delete" class="deleteBtn"> 
				</form>
				<a href="/languages/${language.id}/edit">edit</a>
				
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="outer">
		<div class="formContainer">
			<form:form action="/languages" method="POST" modelAttribute="languageObj">
				<table>
					<tr>
						<td><form:label path="name">Name</form:label></td>
						<td><form:input path="name" /><br><form:errors path="name" class="validationErrors" /></td>
					</tr>
					<tr>
						<td><form:label path="creator">Creator</form:label></td>
						<td><form:input path="creator" /><br><form:errors path="creator" class="validationErrors" /></td>
					</tr>
					<tr>
						<td><form:label path="version">Version</form:label></td>
						<td><form:input type="number" step="0.01" path="version" /><br><form:errors path="version" class="validationErrors" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Submit" class="submitBtn"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>