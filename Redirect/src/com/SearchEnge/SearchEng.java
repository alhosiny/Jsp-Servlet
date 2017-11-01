package com.SearchEnge;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchEng
 */
public class SearchEng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEng() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/SearchR.jsp");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		HashMap<String, String> eng = new HashMap<String, String>();
		eng.put("google", "https://www.google.com.eg/search?q=");
		eng.put("yahoo", "https://search.yahoo.com/search?q=");
		String search = request.getParameter("searchI");
		String searchE = request.getParameter("SearchE");
		
		if(search == null || search.length() == 0) {
			out.println("sorry! it seems there is nothing to search on ");
		}
		else {
			response.sendRedirect(eng.get(searchE)+search);
		}
	}

}
