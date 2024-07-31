<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register customer</title>
<link  type="text/css" rel="stylesheet" href=./css/style.css/>
</head>    
<body>
	<div class="details">
   		<h1>Customer registration</h1>
        <form:form action="registerSuccess"  method="Get"  modelAttribute="customer">
        	<form:hidden path="id"/>
            <table>     
            	<tr>
                	<th> Name: </th>
                	<td> <form:input path="name"/></td>
				</tr>
                <tr>
                	<th> Age: </th>
                	<td> <form:input  path="age"/></td>
               	</tr>
                <tr>
                	<th> City: </th>
                	<td> <form:input  path="city"/></td>
                </tr>
                <tr>
                	<td> <input type="submit" value="Register"/></td>
               	</tr>
            </table>
    	</form:form>
    </div>
</body>
</html>