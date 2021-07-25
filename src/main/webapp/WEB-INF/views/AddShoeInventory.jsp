<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.simplilearn.workshop.model.ShoeInventory" scope="request"></jsp:useBean>
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
<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Product Inventory Manager</h2>

<h3>Add new inventory</h3>


<form:form action = "addinventory" modelAttribute="inventory" method = "POST">
						
							<form:hidden path="shoeid" />
			
							
			<table>
				<tbody>
						<tr>
							<td><label><b>Enter Shoe Name:</b></label></td>
							<td><form:input path="shoename" /></td>
							<td><form:errors path = "shoename" cssClass = "error" style = "color:red"/></td>
						</tr>
						
						<tr>
						 	<td><label><b>Enter Category:</b></label>
							<td><form:select path="category" >
							
							<option value=""> </option>
								<% while(resultSet1.next()){ %>
									<option><%= resultSet1.getString("category")%></option>
								<% 	} %>
							
							</form:select>
							</td> 
							<td><form:errors path = "category" cssClass = "error" style = "color:red"/></td>
						</tr>
						
						<tr>
							<td><label><b>Enter Brand:</b></label>
							<td><form:select path="brand" >
							<option value=""> </option>
							<% while(resultSet2.next()){ %>
							<option><%= resultSet2.getString("brand")%></option>
								<% 	} %>
							</form:select>
							</td> 
							<td><form:errors path = "brand" cssClass = "error" style = "color:red"/></td>
						</tr>					
						
						<tr>		
							<td><label><b>Enter Colour:</b></label>
							<td><form:select path="colour" >
							<option value=""> </option>
							<% while(resultSet3.next()){ %>
							<option><%= resultSet3.getString("colour")%></option>
								<% 	} %>
							</form:select>
							</td> 
							<td><form:errors path = "colour" cssClass = "error" style = "color:red"/></td>
						</tr>
						
						<tr>	
							<td><label><b>Enter Gender:</b></label>
							<td><form:select path="gender" >
							<option value=""> </option>
							<% while(resultSet4.next()){ %>
							<option><%= resultSet4.getString("gender")%></option>
								<% 	} %>
							</form:select>
							</td> 
							<td><form:errors path = "gender" cssClass = "error" style = "color:red"/></td>
						</tr>
						
						<tr>
							<td><label><b>Enter Shoe Size:</b></label>
							<td><form:select path="size" >
							<option value=""> </option>
							<% while(resultSet5.next()){ %>
							<option><%= resultSet5.getString("size")%></option>
								<% 	} %>
							</form:select>
							</td> 
							<td><form:errors path = "size" cssClass = "error" style = "color:red"/></td>
						</tr>
						
						<tr>
							<td><label><b>Enter Shoe Description:</b></label></td>
							<td><form:input path="shoedescription" /></td>
							<td><form:errors path = "shoedescription" cssClass = "error" style = "color:red"/></td>
						</tr>
						
	
						<tr>
							<td><label><b>Enter Price:</b></label></td>
							<td><form:input path="price" /></td>
							<td><form:errors path = "price" cssClass = "error" style = "color:red"/></td>
						</tr>
						
				</tbody>
			</table>
			
	<br>
	<input type="submit" value="Create New Product" class="button" name="addinventory">

			
			
</form:form>
	
						<div style="clear; both;"></div>
							<p><a href="${pageContext.request.contextPath}/login/inventory">Back to inventory list</a> </p>
						</div>
				

</body>
</html>