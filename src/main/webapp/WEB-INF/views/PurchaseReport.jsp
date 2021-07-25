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

String sql1 ="SELECT distinct category FROM shoe_category";
String sql2 ="SELECT distinct brand FROM shoe_brand";
String sql3 ="SELECT distinct paymenttype FROM paymenttypes";

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
<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Purchase Report</h2>

<form action = "applypurchasefiler" method = "GET">

<table>
				<tbody>
					
						<tr>
						 	<td><label><b>Category</b></label>
							<td><select name = "category">
							
							<option value=""> </option>
								<% while(resultSet1.next()){ %>
									<option><%= resultSet1.getString("category")%></option>
								<% 	} %>
							
							</select>
							</td> 
					
							<td><label><b>Brand</b></label>
							<td><select name = "brand">
							<option value=""> </option>
							<% while(resultSet2.next()){ %>
							<option><%= resultSet2.getString("brand")%></option>
								<% 	} %>
							</select>
							</td> 
		
							<td><label><b>Payment Type</b></label>
							<td><select name = "paymenttype">
							<option value=""> </option>
							<% while(resultSet3.next()){ %>
							<option><%= resultSet3.getString("paymenttype")%></option>
								<% 	} %>
							</select>
							</td> 
		
							<td><input type="submit" value="Search" class="button" name="filter"></td> 
								
						</tr>
						
				</tbody>
			</table>
			
	<br><br> 



<hr size = "2" color="black" />

<h4><u>Filtered Results</u></h4>
			<table border="1">
				<tr>
					<th>Customer First Name</th>
					<th>Customer Last Name</th>
					<th>Product Purchased</th>
					<th>Category</th>
					<th>Brand</th>
					<th>Product Price</th>
					<th>Payment Method</th>
					<th>Quantity Purchased</th>
					<th>Total Price Paid</th>
				</tr>
				
				<c:forEach var="tempFilter" items="${filter}"> 
				<tr>
						<td> ${tempFilter.firstname} </td>
						<td> ${tempFilter.lastname} </td>
						<td> ${tempFilter.category} </td>
						<td> ${tempFilter.brand} </td>
						<td> ${tempFilter.shoename} </td>
						<td> ${tempFilter.price} </td>
						<td> ${tempFilter.paymentMethod} </td>	
						<td> ${tempFilter.quantity} </td>
						<td> ${tempFilter.totalprice} </td>	
				</tr>
				
				</c:forEach>
				
										
			</table> 
<br>
<h4><u>All Results</u></h4>
	<table border="1">
				<tr>
					<th>Customer First Name</th>
					<th>Customer Last Name</th>
					<th>Product Purchased</th>
					<th>Category</th>
					<th>Brand</th>
					<th>Product Price</th>
					<th>Payment Method</th>
					<th>Quantity Purchased</th>
					<th>Total Price Paid</th>
				</tr>
				
			  <c:forEach var="tempPurchaselist" items="${purchaselist}"> 
				
				<tr>
					
						<td> ${tempPurchaselist.firstname} </td>
						<td> ${tempPurchaselist.lastname} </td>
						<td> ${tempPurchaselist.category} </td>
						<td> ${tempPurchaselist.brand} </td>
						<td> ${tempPurchaselist.shoename} </td>
						<td> ${tempPurchaselist.price} </td>
						<td> ${tempPurchaselist.paymentMethod} </td>	
						<td> ${tempPurchaselist.quantity} </td>
						<td> ${tempPurchaselist.totalprice} </td>				
					</tr>
				
				</c:forEach>
			</table>
</form>
</body>
</html>


</form>
</body>
</html>