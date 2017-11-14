<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Guess Number</title>
	</head>
	<body>
	    <center>
	        <h1>Guess a Number</h1>
	        <form action="GuessNumber" method="post">
	            <h3>You have <%out.print(session.getAttribute("numberOfTries")); %> times</h3>
		        <label for="Number">Enter the Number between <%out.print(session.getAttribute("minValue")+"-"+session.getAttribute("maxValue")); %>:
		        </label>
		        <input type="text" name="Number" />
		        <input type="submit" value="Enter" />
		    </form>
	    </center>	
	</body>
</html>