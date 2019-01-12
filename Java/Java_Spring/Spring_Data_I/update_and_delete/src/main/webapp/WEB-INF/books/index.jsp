<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
        <tr>
            <td class="title"><a href='/books/<c:out value="${book.id}"/>'><c:out value="${book.title}"/></a></td>
            <td class="desc"><c:out value="${book.description}"/></td>
            <td class="lang"><c:out value="${book.language}"/></td>
            <td class="numOfPages"><c:out value="${book.numberOfPages}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a class="new" href="/books/new">New Book</a>
</body>
</html>