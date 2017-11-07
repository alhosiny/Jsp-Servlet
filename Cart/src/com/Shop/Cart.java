package com.Shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cart
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    RequestDispatcher r = request.getRequestDispatcher("WEB-INF/resources/cart.jsp");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
	    if(session.getAttribute("items") == null) {
	    	session.setAttribute("items", new Vector());
	    }
	    Enumeration names = request.getParameterNames();
	    Vector items = (Vector) session.getAttribute("items");
	    while(names.hasMoreElements()) {
	    	String name = (String)names.nextElement();
	    	items.add(request.getParameter(name));	    	
	    }    
	    session.setAttribute("items", items);
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title> Your cart </title>");
	    out.println("</head>");
	    out.println("<body>");
	    for(int i = 0;i < items.size();i++)
	    	out.println("<h3>"+items.get(i)+"</h3>");
	    out.println("</body>");
	    out.println("</html>");
	}

}
