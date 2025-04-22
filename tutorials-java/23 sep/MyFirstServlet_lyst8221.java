

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
	static
	{
		System.out.println("Servlet loading.........");
	}
   
    public MyFirstServlet() 
    {
    	System.out.println("Servlet Instantiation..");
       
    }

	
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("Servlet initialization...");
	}

	
	public void destroy() 
	{
		System.out.println("Servlet deinstantiation");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Request is processing......");
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><head> <title> Landing Page</title> </head>");
		pw.println("<body bgcolor='cyan'> <marquee><h2>Welcome to Servlet world!</h2><marquee></body>");
		pw.println("</html>");
		pw.close();
		
		
	}

}
