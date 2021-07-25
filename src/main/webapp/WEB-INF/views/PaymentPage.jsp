<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.simplilearn.workshop.model.SalesTable" scope="request"></jsp:useBean>
<jsp:useBean id="command1" class="com.simplilearn.workshop.model.SalesItemTable" scope="request"></jsp:useBean>
<jsp:useBean id="command2" class="com.simplilearn.workshop.model.ShoeInventory" scope="request"></jsp:useBean>
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
ResultSet resultSet1 = null;
%>

<%

try{ 
connection = DriverManager.getConnection(url, user, password);
statement1=connection.createStatement();

String sql1 ="SELECT paymenttype FROM paymenttypes";

resultSet1 = statement1.executeQuery(sql1);
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
<title>Payment Page</title>
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

</style>
<body style="background-color:cornsilk;">
<h1 style="font-family:Garamond; color:darkblue;font-size: 50px;">SportyShoes</h1>
<h2 style="font-family:Garamond; color:darkblue">Secure Payment Page</h2>

<form:form action = "orderconfirmation" modelAttribute="sale" method = "POST"> 
<form:hidden path="salesId" />

			<table>
				<tbody>
						
						<tr>
						 	<td><label><b>Select Payment Method:</b></label>
							<td><form:select path="paymentMethod" required = "true">
							
							<option value=""> </option>
								<% while(resultSet1.next()){ %>
									<option><%= resultSet1.getString("paymenttype")%></option>
								<% 	} %>
							
							</form:select>
							</td> 
						</tr>
						
						
						<tr>
							<td><label><b>Enter Card Number:</b></label></td>
							<td><form:input path="cardnumber" required = "true"/></td>
						</tr>
						
						<tr>
							<td><label><b>Enter CVV Number:</b></label></td>
							<td><form:input path="cvvnumber" maxlength="3" size="3" required = "true"/></td>
						</tr>
						
						<tr>
							<td><label><b>Enter Expiry Date:</b></label></td>
							<td><form:input path="expiryDate" maxlength="4" size="4" required = "true"/></td>
						</tr>
						
						<tr>
							<td><label><b>Total Price:</b></label></td>
							<td><form:input value = "<%=totalcost%>" path="totalPrice" readyonly ="true"/></td>
						</tr>
						
						<tr>
							<td><input type="submit" value="Submit" class="button" name="addsale"></td>
						</tr>
						

						<c:set var="tempCustomer" scope= "session" value="${customer}"/> 
						
						<tr>
						<td><form:hidden path="custId" value = "${tempCustomer.customerId}" name="custId"/> </td>
						</tr>
												
				</tbody>
			</table>
			
						
			<table>
				<tbody>
					<tr>
						<c:set var="tempProduct" scope= "session" value="${product}"/>									
						<td><input value = "${tempProduct.shoeid}"  name = "shoeid" hidden="true"/> </td>
						<td><input value = "${tempProduct.shoename}" name = "shoename" hidden="true"/> </td>
						<td><input value = "${tempProduct.category}" name = "category" hidden="true"/> </td>
						<td><input value = "${tempProduct.brand}" name = "brand" hidden="true"/> </td>
						<td><input value = "${tempProduct.size}" name = "size" hidden="true"/> </td>
						<td><input value = "${tempProduct.colour}" name = "colour" hidden="true"/> </td>
						<td><input value = "${tempProduct.gender}" name = "gender" hidden="true"/> </td>
						<td><input value = "${tempProduct.price}" name = "price" hidden="true"/> </td>	
						<td><input value = <%=quantity%> name = "quantity"  hidden="true"/> </td>
						<td><input value = <%=totalcost%> name = "totalcost"  hidden="true"/> </td>			
					</tr>
				</tbody>
			</table>
			
</form:form>

</body>
</html>