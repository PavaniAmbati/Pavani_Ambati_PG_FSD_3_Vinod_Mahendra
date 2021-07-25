<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.simplilearn.workshop.model.AdminUsers" scope="request"></jsp:useBean>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login form</title>
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

<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Admin Login Form</h2>


<form:form action = "adminhome" modelAttribute="users" method = "POST">
<form:hidden path="id" />
<c:set var="message" scope= "session" value="${message}"/>	
			<table>
				<tbody>
						<tr>
							<td><label><b>Username:</b></label></td>
							<td><form:input path = "username" name = "username"  /></td>
							<td><form:errors path = "username" cssClass = "error" style = "color:red"/><td>
						</tr>
						
						<tr>
							<td><label><b>Password:</b></label></td>
							<td><form:password path = "password" name = "password" /></td>
							<td><form:errors path = "password" cssClass = "error" style = "color:red"/><td>
						</tr>
			
				</tbody>
			</table>
			<br>			
			<input type="submit" value="Login" name = "btnsubmit" class="button"> &nbsp;
			<input type="reset" value="Clear" name="btnclear" class="button"/> &nbsp;
			<input type="button" value="Update Password"
							onclick="window.location.href='ShowUpdatePassword'; return false;"
				   			class="button">
				   			
	
<p>${message}</p>
<c:remove var="message" scope="session" />

			
</form:form>



</body>
</html>