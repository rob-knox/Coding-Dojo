<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="outer">
		<h1>In here</h1>
		<div class="formContainer">
			<form:form action="/languages/${languageObj.id}" method="post" modelAttribute="languageObj">
				<input type="hidden" name="_method" value="put">
				<table>
					<tr>
						<td><form:label path="name">Name</form:label></td>
						<td><form:input path="name" /><form:errors path="name" /></td>
					</tr>
					<tr>
						<td><form:label path="creator">Creator</form:label></td>
						<td><form:input path="creator" /><form:errors path="creator" /></td>
					</tr>
					<tr>
						<td><form:label path="version">Version</form:label></td>
						<td><form:input type="number" step="0.01" path="version" /><form:errors path="version" /></td>
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