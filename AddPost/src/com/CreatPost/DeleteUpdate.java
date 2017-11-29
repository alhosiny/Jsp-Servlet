package com.CreatPost;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUpdate
 */
public class DeleteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataBaseWork db = null;
		try {
			db = new DataBaseWork();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String query = "UPDATE  `test1`.`comment` SET  `content` =  ' "+request.getParameter("content")+"' WHERE  `comment`.`id_comment` ="+request.getParameter("idComment")+";"; 
			db.excuteDml(query)  ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ShowPost");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataBaseWork db = null;
		try {
			db = new DataBaseWork();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String idComment = request.getParameter("idComment");
		String operation = request.getParameter("operation");
		if(operation.equalsIgnoreCase("X")) {
			try {
			    String query = "DELETE FROM `test1`.`comment` WHERE `comment`.`id_comment` = " + idComment+";" ;
				db.excuteDml(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("ShowPost");
		}
		else {
			String idContent = request.getParameter("idContent");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Update </title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.println("<h1> please enter your update </h1>");
			
			out.println("<form action=\"DeleteUpdate\" method=\"get\" >");
			out.println("<textarea type=\"text\" name=\"content\">"+idContent+"</textarea>");
			out.println("<input type=\"hidden\" name=\"idComment\" value=\"" +idComment +"\" />");
			out.println("<input type=\"submit\" value=\"Update\" />");
			out.println("</form>");
			
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		}
		
	}

}
