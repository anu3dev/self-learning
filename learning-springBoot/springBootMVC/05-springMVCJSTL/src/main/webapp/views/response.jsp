<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Details</title>
</head>
<body>
	<center>
		<h1 style="color: red; text-align: center">Displaying data from array</h1>
		<b>Books name:</b>
		<c:forEach var="books" items="${books}">
			${books}
		</c:forEach>
	</center>
</body>
</html>