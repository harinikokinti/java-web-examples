package com.harini.practicePrograms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SetCookieServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// Create cookies for firstname and lastname
		Cookie firstNameCookie = new Cookie("first_name",req.getParameter("first_name"));
		Cookie lastNameCookie = new Cookie("last_name",req.getParameter("last_name"));
		
		//Set expiry date after 24 hrs for both cookies
		firstNameCookie.setMaxAge(24*60*60);
		lastNameCookie.setMaxAge(24*60*60);
		
		//Add these 2 cookies in the response header
		resp.addCookie(firstNameCookie);
		resp.addCookie(lastNameCookie);
		
		PrintWriter out = resp.getWriter();
		String title = "Setting Cookies Example";
		out.println("<html><body><title> " + title + "</title>");
		out.println("First Name :" + req.getParameter("first_name"));
		out.println("Last Name :" + req.getParameter("last_name"));		
		out.println("</body></html>");
				
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doGet(req,resp);
		
	}

}
