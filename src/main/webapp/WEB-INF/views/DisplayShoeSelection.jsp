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
Statement statement4 = null;
Statement statement5 = null;
ResultSet resultSet1 = null;
ResultSet resultSet2 = null;
ResultSet resultSet3 = null;
ResultSet resultSet4 = null;
ResultSet resultSet5 = null;

%>

<%

try{ 
connection = DriverManager.getConnection(url, user, password);
statement1=connection.createStatement();
statement2=connection.createStatement();
statement3=connection.createStatement();
statement4=connection.createStatement();
statement5=connection.createStatement();

String sql1 ="SELECT category FROM shoe_category";
String sql2 ="SELECT brand FROM shoe_brand";
String sql3 ="SELECT colour FROM shoe_colour";
String sql4 ="SELECT gender FROM gender";
String sql5 ="SELECT size FROM shoe_size";

resultSet1 = statement1.executeQuery(sql1);
resultSet2 = statement2.executeQuery(sql2);
resultSet3 = statement3.executeQuery(sql3);
resultSet4 = statement4.executeQuery(sql4);
resultSet5 = statement5.executeQuery(sql5);


} catch (Exception e) {
e.printStackTrace();
}
%>
    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="ISO-8859-1"> 

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
<body>
<body style="background-color:cornsilk;">
<h1 style="font-family:Garamond; color:darkblue;font-size: 50px;">SportyShoes</h1>
<h2 style="font-family:Garamond; color:darkblue">Shoe Selection</h2>

<form action = "applyfiler" method = "GET">


<table>
				<tbody>
					
						<tr>
						 	<td><label><b>Select Category:</b></label>
							<td><select name = "category">
							
							<option value=""> </option>
								<% while(resultSet1.next()){ %>
									<option><%= resultSet1.getString("category")%></option>
								<% 	} %>
							
							</select>
							</td> 
					
							<td><label><b>Select Brand:</b></label>
							<td><select name = "brand">
							<option value=""> </option>
							<% while(resultSet2.next()){ %>
							<option><%= resultSet2.getString("brand")%></option>
								<% 	} %>
							</select>
							</td> 
		
							<td><label><b>Select Colour:</b></label>
							<td><select name = "colour">
							<option value=""> </option>
							<% while(resultSet3.next()){ %>
							<option><%= resultSet3.getString("colour")%></option>
								<% 	} %>
							</select>
							</td> 
		
							<td><label><b>Select Gender:</b></label>
							<td><select name = "gender">
							<option value=""> </option>
							<% while(resultSet4.next()){ %>
							<option><%= resultSet4.getString("gender")%></option>
								<% 	} %>
							</select>
							</td> 
				
							<td><label><b>Select Shoe Size:</b></label>
							<td><select name = "size">
							<option value=""> </option>
							<% while(resultSet5.next()){ %>
							<option><%= resultSet5.getString("size")%></option>
								<% 	} %>
							</select>
							</td> 
							
							<td><input type="submit" value="Apply Filter" class="button" name="filter"></td> 
								
						</tr>
						
				</tbody>
			</table>
			
	<br><br> 

<hr size = "2" color="black" />

	<h4> All Results </h4>
	<table border="1">
				<tr>
					<th>Shoe Name</th>
					<th>Category</th>
					<th>Brand</th>
					<th>Colour</th>
					<th>Gender</th>
					<th>Size</th>
					<th>Price</th>
					<!--  <th>Enter Quantity</th>-->
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempProduct" items="${product}"> 
				
				<c:url var="selectLink" value="/customer/selectproduct">
						<c:param name="shoeid" value="${tempProduct.shoeid}" />
					</c:url>
				<tr>
					
						<td> ${tempProduct.shoename} </td>
						<td> ${tempProduct.category} </td>
						<td> ${tempProduct.brand} </td>
						<td> ${tempProduct.colour} </td>
						<td> ${tempProduct.gender} </td>
						<td> ${tempProduct.size} </td>
						<td> ${tempProduct.price} </td>
						<!-- <td><input type="number" min="1" step="1" max="10" name="quantity" required/><td> -->
															
						<td>
							<a href="${selectLink}">Select for product details</a>
							 <!--   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>-->
						</td>
						
					</tr>
				
				</c:forEach>
				
									
			</table>
			<br>
		 	<h4> Filtered Results </h4>
			<table border="1">
				<tr>
					<th>Shoe Name</th>
					<th>Category</th>
					<th>Brand</th>
					<th>Colour</th>
					<th>Gender</th>
					<th>Size</th>
					<th>Price</th>
					<!--  <th>Enter Quantity</th>-->
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempFilter" items="${filter}"> 
				
				<c:url var="selectLink" value="/customer/selectproduct">
						<c:param name="shoeid" value="${tempFilter.shoeid}" />
					</c:url>
				<tr>
					
						<td> ${tempFilter.shoename} </td>
						<td> ${tempFilter.category} </td>
						<td> ${tempFilter.brand} </td>
						<td> ${tempFilter.colour} </td>
						<td> ${tempFilter.gender} </td>
						<td> ${tempFilter.size} </td>
						<td> ${tempFilter.price} </td>
																		
						<td>
							<a href="${selectLink}">Select for product details</a>
						</td>
						
					</tr>
				
				</c:forEach>
				
										
			</table>

</form>
</body>
</html>