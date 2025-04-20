package com.telusko.learning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class Registration extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public Registration() {
       System.out.println("Servlet instantiated");
    }

	
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("Servlet initialized...");
	}

	
	public void destroy() 
	{
		System.out.println("Servlet de instantiated");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("username");
		
		String address=request.getParameter("useraddr");
		
		String pNumber=request.getParameter("usernumber");
		
		System.out.println(userName + " : "+address + " : "+ pNumber);
		
		
		PrintWriter writer=response.getWriter();
		
		writer.println("<html> <head> <title>Result </title> </head>");
		writer.println("<body bgcolor='cyan' align:'center'>");
		writer.println("<h1> Details which have filled in form</h1>");
		writer.println("<table>");
		writer.println("<tr> <th> NAME</th>   <th> Address</th>   <th> Phone number</th> </tr>");
		writer.println("<tr>  <td> "+userName+" </td>  <td> " +address+" </td>  <td> " +pNumber+" </td>  </tr>");
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
		
	writer.close();
		
		
	}

}
