<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.*" %>
    
<%
String driverClassName = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/pgfsd_sportyshoes?useSSL=false"; //change it
String user = "root";
String password = "Simplilearn$1";

try {
Class.forName(driverClassName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement1 = null;
Statement statement2 = null;
Statement statement3 = null;
ResultSet resultSet1 = null;
ResultSet resultSet2 = null;
ResultSet resultSet3 = null;
%>

<%

try{ 
connection = DriverManager.getConnection(url, user, password);
statement1=connection.createStatement();
statement2=connection.createStatement();
statement3=connection.createStatement();

String sql1 ="SELECT distinct city FROM countrystatelist";
String sql2 ="SELECT distinct state FROM countrystatelist";
String sql3 ="SELECT distinct country FROM countrystatelist";

resultSet1 = statement1.executeQuery(sql1);
resultSet2 = statement2.executeQuery(sql2);
resultSet3 = statement3.executeQuery(sql3);


} catch (Exception e) {
e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
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
<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Customer Report</h2>

<form action = "applycustomerfiler" method = "GET">

<h4><u>Search Criteria</u></h4>
<table>
				<tbody>
				
							<tr>
							<td><label><b>Last Name</b></label>
							<td><input type = "text" name = "lastname"></td>
							</tr>
							
							<tr>
							<td><label><b>Phone Number</b></label>
							<td><input type = "text" name = "phonenumber"></td>
							</tr>
						
							<tr>
							<td><label><b>Email</b></label>
							<td><input type = "text" name = "email"></td>
							</tr>
				
							<tr>
						 	<td><label><b>City</b></label>
							<td><select name = "city">
							
							<option value=""> </option>
								<% while(resultSet1.next()){ %>
									<option><%= resultSet1.getString("city")%></option>
								<% 	} %>
							
							</select>
							</td> 
						</tr>
						
						<tr>
							<td><label><b>State</b></label>
							<td><select name = "state">
							<option value=""> </option>
							<% while(resultSet2.next()){ %>
							<option><%= resultSet2.getString("state")%></option>
								<% 	} %>
							</select>
							</td> 
						</tr>
						<tr>
							<td><label><b>Country</b></label>
							<td><select name = "country">
							<option value=""> </option>
							<% while(resultSet3.next()){ %>
							<option><%= resultSet3.getString("country")%></option>
								<% 	} %>
							</select>
							</td> 
						</tr>
												
						<tr>
							<td><input type="submit" value="Search" class="button" name="filter"></td> 
						</tr>
						
				</tbody>
			</table>
			
	<br><br> 

<hr size = "2" color="black" />

<h4><u>Filtered Results</u></h4>
			<table border="1">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone Number</th>
					<th>Email</th>
					<th>House Number</th>
					<th>Street Name</th>
					<th>City</th>
					<th>State</th>
					<th>Postal Code</th>
					<th>Canada</th>
				</tr>
				
				<c:forEach var="tempFilter" items="${filter}"> 
				<tr>
						<td> ${tempFilter.firstName} </td>
						<td> ${tempFilter.lastName} </td>
						<td> ${tempFilter.phoneNumber} </td>
						<td> ${tempFilter.email} </td>
						<td> ${tempFilter.houseNumber} </td>
						<td> ${tempFilter.streetName} </td>
						<td> ${tempFilter.city} </td>	
						<td> ${tempFilter.state} </td>
						<td> ${tempFilter.postalCode} </td>
						<td> ${tempFilter.country} </td>	
															

					</tr>
				
				</c:forEach>
				
										
			</table>
<br>
<h4><u>All Results</u></h4>
	<table border="1">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone Number</th>
					<th>Email</th>
					<th>House Number</th>
					<th>Street Name</th>
					<th>City</th>
					<th>State</th>
					<th>Postal Code</th>
					<th>Canada</th>
				</tr>
				
			  <c:forEach var="tempCustomer" items="${customer}"> 
				
				<tr>
					
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.phoneNumber} </td>
						<td> ${tempCustomer.email} </td>
						<td> ${tempCustomer.houseNumber} </td>
						<td> ${tempCustomer.streetName} </td>
						<td> ${tempCustomer.city} </td>	
						<td> ${tempCustomer.state} </td>
						<td> ${tempCustomer.postalCode} </td>
						<td> ${tempCustomer.country} </td>					
					</tr>
				
				</c:forEach>
			</table>



</form>
</body>
</html>