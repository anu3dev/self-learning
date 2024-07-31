<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer records</title>
<link  type="text/css" rel="stylesheet" href=./css/style.css/>
</head>
<body>
<div class="details">
	<h1>Customer records:</h1>
	<table>
		<tr>
			<th>Name:</th>
			<th>Age:</th>
			<th>City:</th>
			<th>Update:</th>
			<th>Delete:</th>
		</tr>
		<c:forEach var="customerList" items="${customerList}">
			<c:url var="updateCustomerRecord" value="/updateCustomer">
				<c:param name="customerId" value="${customerList.id}"></c:param>
			</c:url>
			<c:url var="deleteCustomerRecord" value="/deleteCustomer">
				<c:param name="customerId" value="${customerList.id}"></c:param>
			</c:url>
			<tr>
				<td>${customerList.name}</td>
				<td>${customerList.age}</td>
				<td>${customerList.city}</td>
				<td><a href="${updateCustomerRecord}">Update</a></td>
				<td><a href="${deleteCustomerRecord}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="window.location.href='registerCustomer'">Register customer</button>
</div>
</body>
</html>