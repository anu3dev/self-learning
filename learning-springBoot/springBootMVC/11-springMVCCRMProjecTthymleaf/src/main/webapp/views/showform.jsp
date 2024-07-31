<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link  type="text/css" rel="stylesheet" href=./css/style.css/>
<link  type="text/css" rel="stylesheet" href=./css/add-customer-style.css/>
</head>
<body>
<div id="wrapper">
	<div id="header">
			<h1>CRM Registration Form</h1>
	</div>

</div>
<div id="container">
<h2>Register below</h2>
   		
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
                 
                  <td> <input type="submit" value="Register"/></td>
                  </tr>
            
            
            </table>
         
         </form:form>
         
         </div>
         

</body>
</html>