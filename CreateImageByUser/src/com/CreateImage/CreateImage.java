package com.CreateImage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.OutputStream;




/**
 * Servlet implementation class CreateImage
 */
public class CreateImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher re = request.getRequestDispatcher("WEB-INF/view/ImageInformation.jsp");
		re.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("errors", false);
		request.setAttribute("error_message", false);
		request.setAttribute("error_fontSize", false);
		
		
		String message = request.getParameter("message");
		if(message == null || message.length() == 0) {
			request.setAttribute("errors", true);
			request.setAttribute("error_message", true);
		}
		String fontName = request.getParameter("fontName");
		String fontSize = request.getParameter("fontSize");
		if(fontSize == null || fontSize.length() == 0 || !fontSize.matches("[0-9]+")) {
			request.setAttribute("errors", true);
			request.setAttribute("error_fontSize", true);
		}
		if((boolean)request.getAttribute("errors")) {
			PrintWriter out = response.getWriter();
			if((boolean) request.getAttribute("error_message"))
			   out.println("please enter your message");
			if((boolean) request.getAttribute("error_fontSize"))
				out.println("please enter the correct size");
		}
		else {
			int fsize = Integer.parseInt(fontSize);
			response.setContentType("image/jpeg");
			writeJPEG(makeMessageImage(message,
		            fontName,fsize),response.getOutputStream());
		}
	}
	public static BufferedImage makeMessageImage(String message,String fontName,int fontSize) 
	{
	    Font font = new Font(fontName, Font.PLAIN, fontSize);
	    FontMetrics metrics = getFontMetrics(font);
	    int messageWidth = metrics.stringWidth(message);
	    int baselineX = messageWidth/10;
	    int width = messageWidth+2*(baselineX + fontSize);
	    int height = fontSize*7/2;
	    int baselineY = height*8/10;
	    BufferedImage messageImage =
	    new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2d = (Graphics2D)messageImage.getGraphics();
	    g2d.setBackground(Color.white);
	    g2d.clearRect(0, 0, width, height);
	    g2d.setFont(font);
	    g2d.translate(baselineX, baselineY);
	    g2d.setPaint(Color.lightGray);
	    AffineTransform origTransform = g2d.getTransform();
	    g2d.shear(-0.95, 0);
	    g2d.scale(1, 3);
	    g2d.drawString(message, 0, 0);
	    g2d.setTransform(origTransform);
	    g2d.setPaint(Color.black);
	    g2d.drawString(message, 0, 0);
	    return(messageImage);
	}
	private static FontMetrics getFontMetrics(Font font) 
	{
	    BufferedImage tempImage =new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2d = (Graphics2D)tempImage.getGraphics();
	    return(g2d.getFontMetrics(font));
	}
	public static void writeJPEG(BufferedImage image,OutputStream out) 
	{
	    try 
	    {
	        ImageIO.write(image, "jpg", out);
	    } catch(IOException ioe) 
	    {
	        System.err.println("Error outputting JPEG: " + ioe);
	    }
	}


}
