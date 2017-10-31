package com.IDInformation;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PersonalInformation
 */
@WebServlet("/PersonalInformation")
public class PersonalInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/InterInformation.jsp");
        r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("errors", false);
		request.setAttribute("firstName_error", false);
		request.setAttribute("dob_error", false);
	
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String dob = request.getParameter("dob");
		String dobArray[] = dob.split("\\/");
		String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(dob);
		if(m.find()) {
			int month = Integer.parseInt(dobArray[0]);
			int day = Integer.parseInt(dobArray[1]);
			int year = Integer.parseInt(dobArray[2]);
			
			if(month < 1 || month > 12) {
				request.setAttribute("errors", true);
				request.setAttribute("dob_error", true);
			}
			
			if(day < 1 || day > 31) {
				request.setAttribute("errors", true);
				request.setAttribute("dob_error", true);
			}
			
			if(year > 2017) {
				request.setAttribute("errors", true);
				request.setAttribute("dob_error", true);
			}
			
		}
		else {
			request.setAttribute("errors", true);
			request.setAttribute("dob_error", true);
		}
		
		String gender = request.getParameter("gender");
		
		
		
		if(firstName.length() == 0) {
			request.setAttribute("errors", true);
			request.setAttribute("firstName_error", true);
		}
		if(lastName.length() == 0) {
			request.setAttribute("errors", true);
			request.setAttribute("lastName_error", true);
		}
		if((boolean)request.getAttribute("errors")) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title> error in information </title>");
			out.println("</head>");
			out.println("<body>");
			if((boolean)request.getAttribute("firstName_error")) {
				out.println("<h1> please enter your first name</h1>");
			}
			if((boolean)request.getAttribute("lastName_error")) {
				out.println("<h1> please enter your last name</h1>");
			}
			
			if((boolean)request.getAttribute("dob_error")) {
				out.println("<h1> please enter your birth date on form month/day/year and the year less than 2017</h1>");
			}
			out.println("</body>");
			out.println("</html>");
			
		}
		else {
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Personal Information </title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Personal Information </h1>");
			out.println("<h3>First name: </h3>" + firstName);
			out.println("<h3>Last name: </h3>" + lastName);
			out.println("<h3>Date of Birth: </h3>" + dob);
			out.println("<h3>Gender: </h3>" + gender);
			out.println("</body>");
			out.println("</html>");
		}		
		
	}

}
