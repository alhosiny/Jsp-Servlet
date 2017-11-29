<%@page import="com.Students.StudentInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show all</title>
	</head>
	<body>
		<h1 style="border: 5px solid black; border-radius:20%; text-align: center;" >Geek College</h1>
	    <%ArrayList<StudentInfo> students = StudentInfo.getAll();%>
	    <form action="UpdateAndDelete.jsp" >
	    <table>
	       <thead>
	           <tr>
	              <th>id</th>
	              <th>full name</th>
	              <th>department</th>
	              <th>grade</th>
	              <th>hobbies</th>
	              
	            </tr>
	       </thead>
	       <%for(int i = 0;i < students.size(); i++){ 
	             int id = students.get(i).getId();
	       %>
	       <tr>
	             <td><%= id  %></td>
	             <td><%= students.get(i).getFullName() %></td>
	             <td><%= students.get(i).getDepartment() %></td>
	             <td><%= students.get(i).getGrade() %></td>
	             <td><%= students.get(i).getHobbies() %></td>
	             <td> <input type="submit" value="delete" name=<%= id %> ></td>
	             <td> <input type="submit" value="update" name=<%= id %> ></td>
	        </tr>
	        <%} %>    
	    </table>
	    </form>
	    <br><br>
	    <center>
		    <form action="index.jsp">
		        <input type="submit" value="Home">
		    </form>
	    </center>
	    
	</body>
</html>