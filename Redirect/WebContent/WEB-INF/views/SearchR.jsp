<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
	<body>
	   <h1 align="center">Search</h1>
	   <center>
		   <form action="SearchEng" method="post">
		      <label for="searchI">Search:</label>
		      <input type="text" name="searchI" /><br>
		      <p>
			      <input type="radio" name="SearchE" value="google" checked />
			      <label>google</label>
		      </p>
		      <p>
			      <input type="radio" name="SearchE" value="yahoo" />
			      <label>yahoo</label>
		      </p>
		      <input type="submit" value="Search" />	      
		   </form>
	   </center>
	</body>
</html>