package com.CreatPost;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ShowPost
 */
public class ShowPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    DataBaseWork db;
    protected void showPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
    	DataBaseWork db = new DataBaseWork();
		ResultSet result = db.select();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Comment</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1> Welcome </h1>");
		out.println("<form action=\"AddPost\" method=\"post\" >");
		out.println("<textarea name= \"comment\"> </textarea> <br>");
		out.println("<input type=\"submit\" value=\"Add Comment\" />");
		out.println("</form>");
		
		while(result.next()) {
			String idComment = result.getString("id_comment");
			String idContent = result.getString("content");
			out.println("- " + idContent);
			out.println("<br>");
			out.println("<div style=\"display: inline-block;\">");
			out.println("<form action=\"DeleteUpdate\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"idContent\" value=\"" +idContent +"\" />");
			out.println("<input type=\"hidden\" name=\"idComment\" value=\"" +idComment +"\" />");
			out.println("<input type=\"submit\" name=\"operation\" value=\"X\" />");
			out.println("<input type=\"submit\" name=\"operation\" value=\"Update\" />");
			out.println("</form>");
			out.println("</div> <br>");
			
		}
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			showPost(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
