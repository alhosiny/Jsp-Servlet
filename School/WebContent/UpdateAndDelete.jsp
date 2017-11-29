<%@page import="java.util.ArrayList"%>
<%@page import="com.Students.StudentInfo"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update student</title>
	</head>
	<body>
	   <%Enumeration e = request.getParameterNames(); 
	     String id = (String)e.nextElement();
	     StudentInfo st = new StudentInfo();
	     st.setId(Integer.parseInt(id));
	     st.fillStudent();
	     if(request.getParameter(id).equals("delete")){
	    	 st.deleteStudent();
	    	 response.sendRedirect("ShowAll.jsp");
	     }
	     else{	
		    ArrayList<String> allvalid = (ArrayList)session.getAttribute("valid") ;
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
	    
	    <form action="UpdateAndDelete" method="post">
	         <label for="id">Id :</label> <input type="text" name="id"  value=<%=st.getId() %> readonly="readonly"><br> <br>
	         
	         <label for="fullName">Full name :</label><input type="text" name="fullName" value=<%=st.getFullName() %>><br> <br>
	         <% 
	           String selectSoft = "", selectNet="", selectData="";
	           String department = st.getDepartment();  
	           if(department == "Software")
	        	   selectSoft = "selected";
	           else if(department == "Network")
	        	   selectNet = "selected";
	           else
	        	   selectData = "selected";
	         %> 
	         <label for="ch">Choose your department :</label> 
	         <select name="ch">
	           <option value="ch"> choose your department
	           <option value="Software" selected=<%=selectSoft%>> Software
	           <option value="Network" selected=<%=selectNet%>> Network
	           <option value="DataBase" selected=<%=selectData%>> DataBase
	         </select><br> <br>
	         <%
	           String selectFir = "", selectSec = "", selectThir = "", selectFou = "";
	           String grade = st.getGrade();
	           if(grade == "First")
	        	   selectFir = "checked";
	           else if(grade == "Second")
	        	   selectSec = "checked";
	           else if(grade == "Third")
	        	   selectThir = "checked";
	           else 
	        	   selectFou = "checked";
	           
	         %>
	         <label for="grade">Grade : </label> <br>
	         <input type="radio" name="grade"  value = "First"  <%=selectFir%>>First 
	         <input type="radio" name="grade"  value = "Second"<%=selectSec%>>Second <br>
	         <input type="radio" name="grade"  value = "Third" <%=selectThir%>>Third
	         <input type="radio" name="grade"  value = "Fourth"<%=selectFou%>>Fourth <br> <br>
	         
	         <%
	           String selectFo = "", selectRea = "", selectSw = "", selectWr = "";
	           String hobbies = st.getHobbies();
	           if(hobbies.indexOf("football") != -1)
	        	   selectFo = "checked";
	           if(hobbies.indexOf("reading") != -1)
	        	   selectRea = "checked";
	           if(hobbies.indexOf("swimming") != -1)
	        	   selectSw = "checked";
	           if(hobbies.indexOf("writing") != -1)
	        	   selectWr = "checked";
	           
	         %>
	         
	         <label for="Hobbies">Hobbies :</label> <br>
	         <input type="checkbox" name="chh" value="football" <%=selectFo%>> Football        
	         <input type="checkbox" name="chh" value="reading" <%=selectRea%>> Reading <br>
	         <input type="checkbox" name="chh" value="swimming"<%=selectSw%>> Swimming        
	         <input type="checkbox" name="chh" value="writing" <%=selectWr%>> Writing <br> <br>
	         <center>        
	           <input type="submit" value="Update Student">
	         </center>
	    </form>
	    <%}%>
	</body>
</html>