<%@page import="java.awt.GraphicsEnvironment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>JPEG Generator</title>
	</head>
	<body>
	    <%GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment(); %>
	    <%String[] fontFamilyName = env.getAvailableFontFamilyNames(); %>
	    <h1 align="center">JPEG Generation</h1>
	    <form action="CreateImage" method="post">
	       <center>
	          <label for="message">Message: </label>
	          <input type="text" name="message" /> <br>
	          
	          <label for="fontName"> Font name:</label>
	          <select name="fontName">
	               <%for(int i =0;i < fontFamilyName.length;i++) {%>
	               <option><% out.print(fontFamilyName[i]); %> </option>
	               <% } %>
	          </select> <br>
	          <label for="fontSize">Font size:</label>
	          <input type="text" name="fontSize" value="90" /> <br>
	          
	          <input type="submit" value="Build Image" /> 
	       </center>
	    </form>
	</body>
</html>