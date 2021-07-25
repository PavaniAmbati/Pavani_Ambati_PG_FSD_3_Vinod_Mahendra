<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Sporty Shoes</title>
</head>
<style>
h2 {text-align: left;}
h3 {text-align: left;}

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

.button2 {background-color: #008CBA;} /* Blue */
.button3 {background-color: #f44336;} /* Red */ 
.button4 {background-color: #e7e7e7; color: black;} /* Gray */ 
.button5 {background-color: #555555;} /* Black */

</style>
<body style="background-color:cornsilk;">     <!-- 	 -->
<h1 style="font-family:Garamond; color:darkblue;font-size: 50px;">SportyShoes</h1>

<body>

<h2 style="font-family:Garamond;color:darkblue">Welcome to Sporty Shoes</h2>
<h3 style="font-family:Garamond;color:darkblue">Your reliable online shoe company</h3>
<input type="button" class="button" value="Click here to enter store"
				   onclick="window.location.href='ShowShoeSelection'; return false;"
				   class="add-button"/>


</body>
</html>