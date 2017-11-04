<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sign Up</title>
	</head>
	<body>
	  <%
	   String firstName="", lastName="",eMail="";
	   Cookie[] c = request.getCookies();
	   if(c != null){
		   for(int i =0; i < c.length; i++){
			   if(c[i].getName() == "firstName"){
				   firstName = c[i].getValue();
			   }
			   else if(c[i].getName() == "lastName"){
				   lastName = c[i].getValue();
			   }
			   else if(c[i].getName() == "eMail"){
				   eMail = c[i].getValue();
			   }
		   }		   
	   }	  
	  
	  %>
	  <center>
	    <h1>Sign Up</h1>
	    <form action="SaveData" method="post">
	       <label for="firstName">First name:</label>
	       <input type="text" name="firstName" value=<%out.print(firstName); %> ><br>
	       
	       <label for="lastName">Last name:</label>
	       <input type="text" name="lastName" value=<%out.print(lastName); %>><br>
	       
	       <label for="eMail">Email: </label>
	       <input type="text" name="eMail" value=<%out.print(eMail); %>><br>
	       
	       <input type="submit" value="Sign Up">
	    </form>
	  </center>	
	</body>
</html>