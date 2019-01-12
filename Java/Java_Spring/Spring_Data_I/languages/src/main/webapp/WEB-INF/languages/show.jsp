<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
	<table>
		<tr>
			<td>Name</td>
			<td><c:out value="${language.name}"/></td>
		</tr>
		<tr>
			<td>Creator</td>
			<td><c:out value="${language.creator}"/></td>
		</tr>
		<tr>
			<td>Version</td>
			<td><c:out value="${language.version}"/></td>
		</tr>
	</table>
	<a href="/languages">Back</a>
</body>
</html>