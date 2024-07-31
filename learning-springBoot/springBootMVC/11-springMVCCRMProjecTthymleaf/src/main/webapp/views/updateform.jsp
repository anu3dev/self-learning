<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<h1>Customer Registration Form</h1>

<center>
   		<h1 style=' color: red; text-align:center'> Update Details</h1>
         <form:form action="registerCustomer"    modelAttribute="customer">
            <table>
          <form:hidden path="id"/>
                  
                   <tr>
                  <th> Customer First Name</th>
                  <td> <form:input path="firstName"/></td>
                  </tr>
                  
                  <tr>
                  <th> Customer Last Name</th>
                  <td> <form:input  path="lastName"/></td>
                  </tr>
                  
                   <tr>
                  <th> Customer City</th>
                  <td> <form:input  path="city"/></td>
                  </tr>
                  
                   <tr>
                 
                  <td> <input type="submit" value="Update"/></td>
                  </tr>
            
            
            </table>
         
         </form:form>
         
   </center>
</body>
</html>