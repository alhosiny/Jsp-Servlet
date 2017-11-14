package com.Game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuessNumber
 */
public class GuessNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuessNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		if(session.getAttribute("maxValue") == null) {
			session.setAttribute("maxValue", 100);
			session.setAttribute("minValue", 1);
			session.setAttribute("numberOfTries", 5);
		}
		RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/Show.jsp");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int number = Integer.parseInt(request.getParameter("Number"));
		int times = ((Integer)session.getAttribute("numberOfTries")).intValue();
		if(number == 60) {
		  out.println("<html>");
		  out.println("<head>");
		  out.println("<title> Guess Number </title>");
		  out.println("</head>");
		  out.println("<body>");
		  out.println("<center> <h1>You Won</h1> </center>");
		  out.println("</body>");
		  out.println("</html>");
		}
		else if(times - 1 == 0) {
		  out.println("<html>");
		  out.println("<head>");
		  out.println("<title> Guess Number </title>");
		  out.println("</head>");
		  out.println("<body>");
		  out.println("<center> <h1>You Lost</h1> </center>");
		  out.println("</body>");
		  out.println("</html>");
		}
		else {
			if(number < 60) {
				session.setAttribute("minValue", number);
			}
			else {
				session.setAttribute("maxValue", number);
			}
			session.setAttribute("numberOfTries", times - 1);
			response.sendRedirect("GuessNumber");
		}
	}

}
