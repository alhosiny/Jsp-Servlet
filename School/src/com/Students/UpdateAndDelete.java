package com.Students;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateAndDelete
 */
public class UpdateAndDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAndDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("aaaaaaaaaaaaaaaa");
		
		String id = request.getParameter("id");
		String fullName = request.getParameter("fullName");
		String department = request.getParameter("ch");
		String grade = request.getParameter("grade");
		String[] hobbies = request.getParameterValues("chh");
		String shobbies = "";
		if(hobbies != null && hobbies.length != 0) 
		      shobbies = String.join(",", hobbies);
		try {
			ArrayList<String> allvalid = StudentInfo.isValidForUbdate(fullName, department);
			
			HttpSession session = request.getSession();
			session.setAttribute("valid",allvalid);
			if(allvalid != null && allvalid.size() != 0) { 
			  response.sendRedirect("UpdateAndDelete.jsp?"+id+"=updata");				
			}
			else {
				StudentInfo student = new StudentInfo(Integer.parseInt(id), fullName, department, grade, shobbies);
				student.updateStudent();
				response.sendRedirect("ShowAll.jsp");
			}
			
		} catch (NumberFormatException | InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
