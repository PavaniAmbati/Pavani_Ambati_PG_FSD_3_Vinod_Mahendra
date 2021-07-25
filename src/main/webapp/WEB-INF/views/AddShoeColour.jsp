
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.simplilearn.workshop.model.ShoeColour" scope="request"></jsp:useBean>
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

.submit
{
    float: right;
    border: none;
    background:  #008CBA;
    color: white;
    text-align: center;
    display: inline-block;
    font-size: 20px;
    padding: 5px 10px;
    top: 10px;
	right: 10px;
}
.submit:hover
{
    background: green;
    cursor: pointer;
}

</style>

<body style="background-color:cornsilk;">
<input class="submit" type="submit" value="LOGOUT" name = "logout" 
	onclick="window.location.href='users'; return false;"/>
<h1 style="font-family:Garamond; color:darkblue;font-size: 50px;">SportyShoes</h1>
<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Colour Manager</h2>

<h3>Add new colours</h3>



<form:form action = "addcolours" modelAttribute="colours" method = "POST">


						<!-- need to associate this data with brand id -->
						<form:hidden path="colourid" />
			<table>
				<tbody>
						<tr>
							<td><label>Enter Colour:</label></td>
							<td><form:input path="colour" /></td>
							<td><form:errors path = "colour" cssClass = "error" style = "color:red"/><td>
						</tr>
	

				</tbody>
			</table>
			

		<input type="submit" value="Create New Colour" class="button" name="addcolour">
				
</form:form>
	
						<div style="clear; both;"></div>
							<p><a href="${pageContext.request.contextPath}/login/colours">Back to colour list</a> </p>
					
	

</body>
</html>