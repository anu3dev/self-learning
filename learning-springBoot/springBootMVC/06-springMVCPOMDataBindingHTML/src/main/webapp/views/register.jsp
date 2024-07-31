<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<center>
	<h1 style="color:green; text-align: center">Student registration application:</h1>
	<form method="post">
		<table>
			<tr>
				<th>ID:</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>City:</th>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<th>Salary:</th>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit"></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>