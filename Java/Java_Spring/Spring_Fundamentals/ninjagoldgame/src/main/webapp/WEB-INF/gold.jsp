<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Your Gold <span><c:out value="${gold}"/></span></h1>
		</div>
		<div class="boxes">
			<div class="box">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<form action="/farm" method="POST">
					<input type="hidden" name="farm">
					<input type="submit" value="Find Gold!" class="submitButton">
				</form>
			</div>
			
			<div class="box">
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<form action="/cave" method="POST">
					<input type="hidden" name="cave">
					<input type="submit" value="Find Gold!" class="submitButton">
				</form>
			</div>
			
			<div class="box">
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<form action="/house" method="POST">
					<input type="hidden" name="house">
					<input type="submit" value="Find Gold!" class="submitButton">
				</form>
			</div>
			
			<div class="box">
				<h2>Casino</h2>
				<p>(earns 0-50 gold)</p>
				<form action="/casino" method="POST">
					<input type="hidden" name="casino">
					<input type="submit" value="Find Gold!" class="submitButton">
				</form>
			</div>
		</div>
		<h2>Activities</h2>
		<div class="output">
			<ul>
				<c:forEach var="msg" items="${messages}">
					<c:if test="${msg.contains(\"lost\")}">
				         <li class="red"><c:out value="${msg}"/></li>
				    </c:if>
				    <c:if test="${msg.contains(\"earned\")}">
				         <li class="green"><c:out value="${msg}"/></li>
				    </c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>