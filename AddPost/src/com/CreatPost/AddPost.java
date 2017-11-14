package com.CreatPost;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPost
 */
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void addPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
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
		//String query = "SELECT * FROM comment";
		//ResultSet result = s.executeQuery(query);
		String comment = request.getParameter("comment");
		String query = "INSERT INTO `test1`.`comment` ( `id_comment` , `content` ) VALUES ( NULL , '"+comment+"' );";
		s.executeUpdate(query);
		response.sendRedirect("ShowPost");
    }  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			addPost(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
