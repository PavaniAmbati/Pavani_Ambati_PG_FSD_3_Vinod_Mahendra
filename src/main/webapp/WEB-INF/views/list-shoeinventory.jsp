<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Inventory</title>
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
<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Admin User Manager</h2>


	
			<!--  add our html table here -->
		
			<table border = "1">
				<tr>
					<th>Shoe Name</th>
					<th>Category</th>
					<th>Brand</th>
					<th>Colour</th>
					<th>Gender</th>
					<th>Size</th>
					<th>Shoe Description</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our inventory-->
				<c:forEach var="tempInventory" items="${inventory}"> 
				
				<!-- construct an "delete" link with inventory id -->
					<c:url var="deleteLink" value="/login/deleteinventory">
						<c:param name="shoeid" value="${tempInventory.shoeid}" />
					</c:url>
				
										
					<tr>
					
						<td> ${tempInventory.shoename} </td>
						<td> ${tempInventory.category} </td>
						<td> ${tempInventory.brand} </td>
						<td> ${tempInventory.colour} </td>
						<td> ${tempInventory.gender} </td>
						<td> ${tempInventory.size} </td>
						<td> ${tempInventory.shoedescription} </td>
						<td> ${tempInventory.price} </td>
															
						<td>
							<a href="${deleteLink}"
							 onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
				
										
			</table>
					
			<!-- put new button: Add Inventory -->
		
			<input type="button" value="Add New Inventory"
				   onclick="window.location.href='showFormForAddInv'; return false;"
				   class="button"
			/>
		
</body>

</html>