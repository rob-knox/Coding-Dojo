<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Code</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="main">
			<p class="error"><c:out value="${error}" /></p>
			<p>What is the code?</p>
			<form action="/login" method="POST">
				<input type="text" name="answer">
				<input type="submit" value="Try Code" class="submitButton">
			</form>
		</div>
	</div>
</body>
</html>