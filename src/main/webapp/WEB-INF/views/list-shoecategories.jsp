<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Categories</title>
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
<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Category Manager</h2>

	
			<!--  add our html table here -->
		
			<table border = "1">
				<tr>
					<th>Category Name</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers-->
				<c:forEach var="tempCategory" items="${categories}"> 
				
				<!-- construct an "delete" link with category id -->
					<c:url var="deleteLink" value="/login/deletecategories">
						<c:param name="categoryId" value="${tempCategory.categoryId}" />
					</c:url>
				
										
					<tr>
						<td> ${tempCategory.category} </td>	
											
						<td>
							<a href="${deleteLink}"
							 onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
				
										
			</table>
			<br>
			<!-- put new button: Add Category -->
		
			<input type="button" value="Add New Categories"
				   onclick="window.location.href='showFormForAddCats'; return false;"
				   class="button"
			/>
</body>

</html>