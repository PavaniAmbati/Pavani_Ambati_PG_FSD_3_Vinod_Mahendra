<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.simplilearn.workshop.model.Customer" scope="request"></jsp:useBean>
<jsp:useBean id="command1" class="com.simplilearn.workshop.model.ShoeInventory" scope="request"></jsp:useBean>
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
 
<%
 int quantity = Integer.parseInt(request.getParameter("quantity")); 
 float totalcost = Float.parseFloat(request.getParameter("totalcost"));%>
 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Page</title>
</head>
<style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.error {
    color: red;
    font-style: italic;
}

</style>
<body style="background-color:cornsilk;">
<h1 style="font-family:Garamond; color:darkblue;font-size: 50px;">SportyShoes</h1>
<h2 style="font-family:Garamond; color:darkblue">Customer Registration</h2>


<form:form action = "addcustomer" modelAttribute="customer" method = "POST"> 


<form:hidden path="customerId" />
<table>
				<tbody>
			
						<tr>
							<td><label><b>Enter FirstName:</b></label></td>
							<td><form:input path="firstName" /></td>
							<td><form:errors path="firstName" cssClass="error" style = "color:red" /></td>
						</tr>
						
						<tr>
							<td><label><b>Enter Last Name:</b></label></td>
							<td><form:input path="lastName" /></td>
							<td><form:errors path="lastName" cssClass="error" style = "color:red" /></td>
						</tr>
						
						<tr>
							<td><label><b>Enter Phone Number:</b></label></td>
							<td><form:input path="phoneNumber" /></td>
							<td><form:errors path="phoneNumber" cssClass="error" style = "color:red" /></td>
						</tr>
						
						<tr>
							<td><label><b>Email:</b></label></td>
							<td><form:input path="email" /></td>
							<td><form:errors path="email" cssClass="error" style = "color:red" /></td>
						</tr>
						
						<tr>
							<td><label><b>House Number:</b></label></td>
							<td><form:input path="houseNumber" style = "color:red" /></td>
							<td><form:errors path="houseNumber" cssClass="error"  style = "color:red"/></td>
						</tr>
						
						<tr>
							<td><label><b>Street Name:</b></label></td>
							<td><form:input path="streetName" /></td>
							<td><form:errors path="streetName" cssClass="error"  style = "color:red"/></td>
						</tr>
						
						<tr>
							<td><label><b>City</b></label>
							<td><form:select name = "city" path="city">
							
							<option value=""> </option>
								<% while(resultSet1.next()){ %>
									<option><%= resultSet1.getString("city")%></option>
								<% 	} %>
							</form:select>
							<td><form:errors path="city" cssClass="error"  style = "color:red"/></td>
							</td> 
						</tr>
						
						<tr>
							<td><label><b>State:</b></label></td>
							<td><form:select name = "state" path="state">
							
							<option value=""> </option>
								<% while(resultSet2.next()){ %>
									<option><%= resultSet2.getString("state")%></option>
								<% 	} %>
							</form:select>
							<td><form:errors path="state" cssClass="error"  style = "color:red"/></td>
							
							</td>
						</tr>
	
						<tr>
							<td><label><b>Postal Code:</b></label></td>
							<td><form:input path="postalCode" /></td>
							<td><form:errors path="postalCode" cssClass="error"  style = "color:red"/></td>
						</tr>
						
						<tr>
							<td><label><b>Country:</b></label></td>
							<td><form:select name = "country" path="country">
							
							<option value=""> </option>
								<% while(resultSet3.next()){ %>
									<option><%= resultSet3.getString("country")%></option>
								<% 	} %>
							</form:select>
							<td><form:errors path="country" cssClass="error"  style = "color:red"/></td>
							
							
							</td>
						</tr>
	
		
						<tr>
							<td><input type="submit" value="Proceed to Secure Payment" class="button" name="addcustomer" ></td>
						</tr>

				</tbody>
			</table>
			
			<table>
				<tbody>
					<tr>
						<c:set var="tempProduct" scope= "session" value="${product}"/> 
						<td><input value = "${tempProduct.shoeid}" name = "shoeid" hidden="true"/> </td>
						<td><input value = "${tempProduct.shoename}" name = "shoename"  hidden="true"/> </td>
						<td><input value = "${tempProduct.category}" name = "category"  hidden="true"/> </td>
						<td><input value = "${tempProduct.brand}" name = "brand"  hidden="true"/> </td>
						<td><input value = "${tempProduct.size}" name = "size"  hidden="true"/> </td>
						<td><input value = "${tempProduct.colour}" name = "colour"  hidden="true"/> </td>
						<td><input value = "${tempProduct.gender}" name = "gender"  hidden="true"/> </td>
						<td><input value = "${tempProduct.price}" name = "price"  hidden="true"/> </td>	
						<td><input value = <%=quantity%> name = "quantity"  hidden="true"/> </td>
						<td><input value = <%=totalcost%> name = "totalcost"  hidden="true"/> </td>				
					</tr>
				</tbody>
			</table>
			
			
			
</form:form>


</body>
</html>