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
    protected void showPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
    	try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hostName = "localhost:3306";
		String dbName = "test1";
		String mySqlUrl =  "jdbc:mysql://"+hostName+"/"+dbName;
		String user = "root";
		String password = "";
		
		java.sql.Connection c = (java.sql.Connection)DriverManager.getConnection(mySqlUrl, user, password);
		java.sql.Statement s = (java.sql.Statement)c.createStatement();
		String query = "SELECT * FROM comment  ORDER BY `comment`.`id_comment` DESC";
		ResultSet result = s.executeQuery(query);
		
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
			out.println(result.getString("id_comment") + ": " + result.getString("content") + "<br>");
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
