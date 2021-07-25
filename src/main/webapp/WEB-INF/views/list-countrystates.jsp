<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Country States</title>
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
<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Country/State Manager</h2>


			<!--  add our html table here -->
		
			<table border = "1">
				<tr>
					<th>Country</th>
					<th>State</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers-->
				<c:forEach var="tempCountrystate" items="${countrystates}"> 
				
				<!-- construct an "delete" link with brand id -->
					<c:url var="deleteLink" value="/login/deleteCountryStates">
						<c:param name="id" value="${tempCountrystate.id}" />
					</c:url>
				
										
					<tr>
						<td> ${tempCountrystate.country} </td>	
						<td> ${tempCountrystate.state} </td>	
											
						<td>
							<a href="${deleteLink}"
							 onclick="if (!(confirm('Are you sure you want to delete this country state record?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
				
										
			</table>
			<br>
			<!-- put new button: Add Brand -->
		
			<input type="button" value="Add New Countrystates"
				   onclick="window.location.href='showFormForAddCtry'; return false;"
				   class="button"
			/>
		
		</div>
	
	</div>
	

</body>

</html>