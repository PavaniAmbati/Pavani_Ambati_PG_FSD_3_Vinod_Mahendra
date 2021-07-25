<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.simplilearn.workshop.model.SalesTable" scope="request"></jsp:useBean>
<jsp:useBean id="command1" class="com.simplilearn.workshop.model.SalesItemTable" scope="request"></jsp:useBean>
<jsp:useBean id="command2" class="com.simplilearn.workshop.model.ShoeInventory" scope="request"></jsp:useBean>
<jsp:useBean id="command3" class="com.simplilearn.workshop.model.Customer" scope="request"></jsp:useBean>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
 int quantity = Integer.parseInt(request.getParameter("quantity")); 
 float totalcost = Float.parseFloat(request.getParameter("totalcost"));%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Confirmation Page</title>
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
<h2 style="font-family:Garamond; color:darkblue">Order Confirmation</h2>

	
<form:form action = "ordersummary" modelAttribute="saleitem" method = "POST"> 
<form:hidden path="salesItemId" />


<c:set var="tempSale" scope= "session" value="${sale}"/>	
	<c:set var="tempProduct" scope= "session" value="${product}"/>	
		<c:set var="tempCustomer" scope= "session" value="${customer}"/>	
		
<c:url var="editProductdetails" value="/customer/ShowShoeSelection"/>
<c:url var="editCustomerdetails" value="/customer/showFormForAddCust"/>
<c:url var="editPaymentdetails" value="/customer/addcustomer"/>
		

<h4><u>Product Details</u></h4>
<table>
				<tbody>
					
						<tr>
							<td><label><b>Sales ID</b></label></td>
							<td><form:input value = "${tempSale.salesId}"  path="salesId" name = "salesId" readonly = "true" /></td>
						</tr>
						
						<tr>
							<td><form:input value = "${tempProduct.shoeid}" path="shoeId" name = "shoeid" hidden = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Shoe Name</b></label></td>
							<td><form:input value = "${tempProduct.shoename}" path="shoename" name = "shoename" readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Category</b></label></td>
							<td><form:input value = "${tempProduct.category}" path="category" name = "category" readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Brand</b></label></td>
							<td><form:input value = "${tempProduct.brand}" path="brand" name = "brand" readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Size</b></label></td>
							<td><form:input value = "${tempProduct.size}" path="size" name = "size" readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Colour</b></label></td>
							<td><form:input value = "${tempProduct.colour}" path="colour" name = "colour" readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Gender</b></label></td>
							<td><form:input value = "${tempProduct.gender}" path="gender" name = "gender" readonly = "true"/> </td>
						</tr>
	
						<tr>
							<td><label><b>Price</b></label></td>
							<td><form:input value = "${tempProduct.price}" path="price" name = "price" readonly = "true"/> </td>	
						</tr>
						
						<tr>
						<td><label><b>Quantity</b></label></td>
						<td><form:input value = "<%=quantity%>" path = "quantity" name = "quantity" readonly = "true" /> </td>
						</tr>
						
						<tr>
						<td><label><b>Total Cost</b></label></td>
						<td><form:input value = "<%=totalcost%>" path = "totalprice" name = "totalcost" readonly = "true" /> </td>	
						</tr>
						
				</tbody>
			</table>
			
<h4><u> Customer Details</u></h4>
				
			<table>
				<tbody>
						<tr>		
							<td><form:input value = "${tempCustomer.customerId}"  path="customerId" name = "customerId" hidden = "true"/></td>
						</tr>
				
						<tr>
							<td><label><b>First Name</b></label></td>
							<td><input value = "${tempCustomer.firstName}" name = "firstname" readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Last Name</b></label></td>
							<td><input value = "${tempCustomer.lastName}" name = "lastname"  readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Phone Number</b></label></td>
							<td><input value = "${tempCustomer.phoneNumber}"  readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Email</b></label></td>
							<td><input value = "${tempCustomer.email}"  readonly = "true"/> </td>
						</tr>
	
						<tr>
							<td><label><b>House Number</b></label></td>
							<td><input value = "${tempCustomer.houseNumber}"  readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>Street Name</b></label></td>
							<td><input value = "${tempCustomer.streetName}"  readonly = "true"/> </td>
						</tr>
						
						<tr>
							<td><label><b>City</b></label></td>
							<td><input value = "${tempCustomer.city}"  readonly = "true"/> </td>
						</tr>
	
						<tr>
							<td><label><b>Postal Code</b></label></td>
							<td><input value = "${tempCustomer.postalCode}"  readonly = "true"/> </td>
						</tr>
						

				</tbody>
			</table>
			
<h4><u>Payment Details</u></h4>

			<table>
				<tbody>
						<tr>
							<td><label><b>Payment Method</b></label></td>
							<td><input value = "${tempSale.paymentMethod}" name = "paymentmethod"  readonly = "true"/> </td>
						</tr>
						
				</tbody>
			</table>
			<br>
						<tr>
							<td><a href="${editProductdetails}">Update details</a></td>
						</tr>
						
			
			<table>
					<tr>
						<td><input type="submit" value="Confirm Sale" class="button" name="confirmsale" formnovalidate></td>
					</tr>
			</table>
			
</form:form>
