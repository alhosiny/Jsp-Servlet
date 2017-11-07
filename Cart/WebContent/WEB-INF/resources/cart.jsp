<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Shopping</title>
</head>
	<body>
		<center>
		   <h1>Welcome in the Market</h1>
		   <form action="Cart" method="post">
		       <input type="checkbox" name="Apple" value="Apple  3$"> Apple <br>
		       <input type="checkbox" name="Orange" value="Orange  1$"> Orange <br>
		       <input type="checkbox" name="Pineapple" value="Pineapple  5$"> Pineapple <br>
		       <input type="submit" value="Submit Order">	       
		   </form>
		</center>
	</body>
</html>