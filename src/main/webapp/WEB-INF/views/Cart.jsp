<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
 int quantity = Integer.parseInt(request.getParameter("quantity")); 
 float price = Float.parseFloat(request.getParameter("price"));%>
 <% 
 float totalprice = quantity*price;%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<body>
<body style="background-color:cornsilk;">
<h1 style="font-family:Garamond; color:darkblue;font-size: 50px;">SportyShoes</h1>
<h2 style="font-family:Garamond; color:darkblue">Shopping Cart</h2>

	
<form:form action = "showFormForAddCust" modelAttribute="product" method = "GET"> 

<c:set var="tempProduct" scope= "session" value="${product}"/> 
<c:set var="tempQuantity" scope= "session" value="${quantity}"/> 




									
					<table>
						<tr>
						<th><label>ShoeID</label><th>
						<td><form:input path="shoeid" value = "${tempProduct.shoeid}" readonly="true"/></td>
						</tr>
	

						<tr>
						<th><label>Shoe Name</label><th>
						<td><form:input path="shoename" value = "${tempProduct.shoename}" readonly="true"/> </td>
						</tr>
		
						<tr>
						<th><label>Category</label><th>				
						<td><form:input path="category" value = "${tempProduct.category}" readonly="true"/> </td>
						</tr>
		
						<tr>
						<th><label>Brand</label><th>	
						<td><form:input path="brand" value = "${tempProduct.brand}" readonly="true"/> </td>
						</tr>
		
						<tr>
						<th><label>Colour</label><th>		
						<td><form:input path="colour" value = "${tempProduct.colour}" readonly="true"/> </td>
						</tr>
					
						<tr>
						<th><label>Gender</label><th>		
						<td><form:input path="gender" value = "${tempProduct.gender}" readonly="true"/> </td>
						</tr>

						<tr>
						<th><label>Size</label><th>				
						<td><form:input path="size" value = "${tempProduct.size}" readonly="true"/> </td>
						</tr>

						<tr>
						<th><label>Price</label><th>
						<td><form:input path="price" value = "${tempProduct.price}" readonly="true"/> </td>
						</tr>
						
						<tr>
						<th><label>Quantity</label><th>
						<td><input type = "text" value = "${tempQuantity}" name = "quantity" readonly="true"/> </td>
						</tr>
						
											
						<tr>
						<th><label>Total Cost</label><th>
						<td><input type = "text" value = <%=totalprice%> name = "totalcost" readonly="true"/> </td>
						</tr>
						
						<tr>
						<th><label>Shoe Description</label><th>
						<td><form:input path="shoedescription" value = "${tempProduct.shoedescription}" size="125" readonly="true"/> </td>
						</tr>
							
						
					</table>	
					<br>
				
			
				
  		
				<!--<c:url var="selectLink" value="/customer/showFormForAddCust">
						<c:param name="shoeid" value="${tempProduct.shoeid}" />
					</c:url>
				<tr>-->
															
						<!--  <td>
							<a href="${selectLink}">Register</a>-->
							 <!--   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>-->
						<!--  </td>-->
					</tr>
						<tr>
							<td><input type="submit" value="Register" class="button" name="register"></td>
						</tr>
		
</form:form>

</body>
</html>