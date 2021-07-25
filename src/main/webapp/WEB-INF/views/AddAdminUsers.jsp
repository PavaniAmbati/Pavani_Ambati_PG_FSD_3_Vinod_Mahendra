<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.simplilearn.workshop.model.AdminUsers" scope="request"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoes Setup Page</title>
</head>

<style>
.button {
  background-color: #4CAF50; /* Green */
  color: white;
  text-align: center;
  display: inline-block;
  font-size: 14px;
  margin: 4px 2px;
  cursor: pointer;
}

</style>

<body style="background-color:cornsilk;">
<h1 style="font-family:Garamond; color:darkblue;font-size: 50px;">SportyShoes</h1>
<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Admin User Manager</h2>

<h3>Add new admin users</h3>


<form:form action = "addadminusers" modelAttribute="adminusers" method = "POST">
						
						<!-- need to associate this data with category id -->
						<form:hidden path="id" />
			<table>
				<tbody>
						<tr>
							<td><label><b>Enter User Name:</b></label></td>
							<td><form:input path="username" /></td>
							<td><form:errors path = "username" cssClass = "error" style = "color:red"/><td>
						</tr>
						
							<tr>
							<td><label><b>Enter Temp Password:</b></label></td>
							<td><form:password path="password" /></td>
							<td><form:errors path = "password" cssClass = "error" style = "color:red"/><td>
						</tr>
				</tbody>
			</table>
			
	
				<br>
				<input type="submit" value="Create new user" class="button" name="addusers">
				<div style="clear; both;"></div>
				<p><a href="${pageContext.request.contextPath}/login/ShowAdminUsers">Back to admin users list</a> </p>
				
			
			
</form:form>

</body>
</html>