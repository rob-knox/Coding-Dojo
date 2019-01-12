<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
	<h4>Submitted Info</h4>
		<table>
			<tr>
				<td class="half">Name: </td>
				<td class="half"><c:out value="${name}"/></td>
			</tr>
			<tr>
				<td class="half">Dojo Location: </td>
				<td class="half"><c:out value="${location}"/></td>
			</tr>
			<tr>
				<td class="half">Favorite Language: </td>
				<td class="half"><c:out value="${language}"/></td>
			</tr>
			<tr>
				<td class="half">Comment: </td>
				<td class="half"><c:out value="${comment}"/></td>
			</tr>
		</table>
	</div>
</body>
</html>