<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h2 style="font-family:Garamond; color:darkblue">Product Details</h2>

<form action = "cart" method = "GET"> 
	<c:set var="tempProduct" scope= "session" value="${product}"/> 


					<table border="1">


						<tr>
						<th><Label> Shoe Name:</Label> </th> 
						<td><input type=text value = "${tempProduct.shoename}" readonly ></td>
						</tr>
						
						
						<tr>
						<th><Label> Category:</Label> </th> 
						<td><input type=text value = "${tempProduct.category}" readonly ></td>
						</tr>
						
						<tr>
						<th><Label> Brand:</Label> </th> 
						<td><input type=text value = "${tempProduct.brand}" readonly ></td>
						</tr>
						
						<tr>
						<th><Label> Colour:</Label> </th> 
						<td><input type=text value = "${tempProduct.colour}" readonly ></td>
						</tr>
						
						<tr>
						<th><Label>Gender:</Label> </th> 
						<td><input type=text value = "${tempProduct.gender}" readonly ></td>
						</tr>
						
						<tr>
						<th><Label>Size:</Label> </th> 
						<td><input type=text value = "${tempProduct.size}" readonly ></td>
						</tr>
						
						<tr>
						<th><Label>Price:</Label> </th> 
						<td><input type=text value = "${tempProduct.price}" name = "price" readonly ></td>
						</tr>
						

					</table>	
					<br>	
					
					<table>								
						<tr>
						<th><Label> Shoe Description:</Label> </th> 
						<td><input type=text value = "${tempProduct.shoedescription}" size="125" readonly ></td>
						</tr>
						
					</table>
					<br>	
					<label><b>Enter Quantity:</b></label>
					<input type = "number" name = "quantity" required/>
			
  					<br><br>
  					
					<input type="submit" value="Submit" class="button" name="submit">
					
					<input type = text name = "shoeid" value = "${tempProduct.shoeid}" hidden>
				
				
		


</form>					

</body>
</html>