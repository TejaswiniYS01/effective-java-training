<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book's Api Home Page</title>
</head>
<body>

<h1>Welcome to the Book's API Home Page</h1>

<h2>Available Services</h2>

<ul>
	<c:forEach items="${services}" var="service">
		<li><a href="${service.url }">${service.service }</a></li>
	</c:forEach>

</ul>


</body>
</html>