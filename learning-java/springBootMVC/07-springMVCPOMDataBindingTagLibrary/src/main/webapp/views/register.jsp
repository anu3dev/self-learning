<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<center>
	<h1 style="color:green; text-align: center">Student registration application:</h1>
	<form:form method="post" modelAttribute="emp">
		<table>
			<tr>
				<th>ID:</th>
				<td><form:input  path="id"/></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<th>City:</th>
				<td><form:input  path="city"/></td>
			</tr>
			<tr>
				<th>Salary:</th>
				<td><form:input  path="salary"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit"></td>
			</tr>
		</table>
	</form:form>
</center>
</body>
</html>