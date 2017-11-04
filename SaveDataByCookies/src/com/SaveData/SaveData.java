package com.SaveData;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveData
 */
public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/EnterData.jsp");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String eMail = request.getParameter("eMail");
		Cookie firstNameC = new Cookie("firstName",firstName);
		Cookie lastNameC = new Cookie("lastName",lastName);
		Cookie eMailC = new Cookie("eMail",eMail);
		response.addCookie(firstNameC);
		response.addCookie(lastNameC);
		response.addCookie(eMailC);
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Thanks for Sing Up </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1> Thanks for Sing Up ^_^ </h1>");
		out.println("<ul>");
		out.println("<li> First name: " + firstName + "</li>");
		out.println("<li> Last name: " + lastName + "</li>");
		out.println("<li> Email: " + eMail + "</li>");
		out.println("</ul>");
		out.println("</center>");
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
