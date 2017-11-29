<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add student</title>
	</head>
	<body>
	    <h1 style="border: 5px solid black; border-radius:20%; text-align: center;" >Geek College</h1>
	   <%ArrayList<String> allvalid = (ArrayList)session.getAttribute("valid") ;
	      if(allvalid != null && allvalid.size() != 0){
	      
	       %>
	    <ul>
	      <%
		    for(int i = 0;i < allvalid.size(); i++){    
	      %> 
	      <li style="color: red;"> * <%= allvalid.get(i) %> </li>
	      <% } %>
	    </ul>
	    <% } %>
	    
	    <form action="AddStudent" method="post">
	         <label for="id">Id :</label> <input type="text" name="id" ><br> <br>
	         
	         <label for="fullName">Full name :</label><input type="text" name="fullName"><br> <br>
	         
	         <label for="ch">Choose your department :</label> 
	         <select name="ch">
	           <option value="ch"> choose your department
	           <option value="Software"> Software
	           <option value="Network"> Network
	           <option value="DataBase"> DataBase
	         </select><br> <br>
	         
	         <label for="grade">Grade : </label> <br>
	         <input type="radio" name="grade"  value = "First" checked="checked">First 
	         <input type="radio" name="grade"  value = "Second">Second <br>
	         <input type="radio" name="grade"  value = "Third">Third
	         <input type="radio" name="grade"  value = "Fourth">Fourth <br> <br>
	         
	         <label for="Hobbies">Hobbies :</label> <br>
	         <input type="checkbox" name="chh" value="football" > Football        
	         <input type="checkbox" name="chh" value="reading" > Reading <br>
	         <input type="checkbox" name="chh" value="swimming" > Swimming        
	         <input type="checkbox" name="chh" value="writing" > Writing <br> <br>
	         <center>        
	           <input type="submit" value="Add Student">
	         </center>
	    </form>  
	</body>
</html>