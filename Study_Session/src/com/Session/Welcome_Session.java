package com.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome_Session
 */
public class Welcome_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome_Session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session =  request.getSession();
		Integer accessCount = (Integer)session.getAttribute("accessCount");
		String message = "welcome";
		if(accessCount == null) {
			accessCount = new Integer(0);
		}
		else {
			message += " back";
			accessCount = new Integer(accessCount + 1);
		}
		session.setAttribute("accessCount", accessCount);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome</title>");
		out.println("<link rel="+"'styleSheet'"+"href="+"'resources/css/themes.css'"+">");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>"+message+"</h1>");
		out.println("<table>");
		out.println("<tr><td>Id</td> <td>"+session.getId()+"</td> </tr>");
		out.println("<tr><td>Creat time</td> <td>"+ new Date(session.getCreationTime())+"</td> </tr>");
		out.println("<tr><td>last access time</td> <td>"+new Date(session.getLastAccessedTime())+"</td> </tr>");
		out.println("<tr><td>access count</td> <td>"+accessCount+"</td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
