<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
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
<h2 style="font-family:Garamond; color:darkblue;font-size: 30px;">Admin Home Page</h2>


<form>
<hr size = "2" color="black" />
<h3 style="font-family:Garamond">Admin Manager</h3>

<input type="button" value="Admin Users Setup"
				   onclick="window.location.href='ShowAdminUsers'; return false;"
				   class="button"
			/>


<input type="button" value="Update Password"
				   onclick="window.location.href='ShowUpdatePassword'; return false;"
				   class="button"
			/>

<br><br>
<hr size = "2" color="black" />
<h3 style="font-family:Garamond">Product Manager</h3>
<input type="button" value="Shoe Brand Setup"
				   onclick="window.location.href='brands'; return false;"
				   class="button"
/>



<input type="button" value="Shoe Category Setup"
				   onclick="window.location.href='categories'; return false;"
				   class="button"
			/>
	
<input type="button" value="Shoe Inventory Setup"
				   onclick="window.location.href='inventory'; return false;"
					   class="button"
			/>
			
<input type="button" value="Shoe Colour Setup"
				   onclick="window.location.href='colours'; return false;"
					   class="button"
			/>
			
<input type="button" value="Shoe Size Setup"
				   onclick="window.location.href='sizes'; return false;"
					   class="button"
			/>
			
<input type="button" value="Country/State Setup"
				   onclick="window.location.href='CountryStates'; return false;"
					   class="button"
			/>
			
			
<br><br>	
<hr size = "2" color="black" />
<h3 style="font-family:Garamond">Report Manager</h3>
<input type="button" value="Reports"
				   onclick="window.location.href='reports'; return false;"
					   class="button"
			/>
			
<hr size = "2" color="black" />
</form>
</body>
</html>