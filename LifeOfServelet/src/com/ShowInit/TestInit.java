package com.ShowInit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInit
 */
@WebServlet("/TestInit")
public class TestInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestInit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    int number_of_init = 0;
    int number_of_refresh = 0;
    
    public void init() throws ServletException {
    	number_of_init++;    	    	
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	number_of_refresh++;
    	PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>init access one time </title>");		
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> number of calling init method = " + number_of_init + "</h3>");
		out.println("<h3> number of refresh = " + number_of_refresh + "</h3>");
		
		out.println("</doby>");
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
