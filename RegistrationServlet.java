package com.as.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.as.service.UserService;

public class RegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String uemail = request.getParameter("uemail");
		String umobile = request.getParameter("umobile");
		UserService user_Service = new UserService();
		String status = user_Service.registration(uname, upwd, uemail, umobile);
		out.println("<html>");
		out.println("<body bgcolor='lightblue'>");
		out.println("<center>");
		out.println("<br><br><br>");
		out.println("<font color='red' size='6'>");
		out.println("<b>");
		out.println("Registration Status :"+status);
		out.println("</b></font></center></body></html>");
	}
}

