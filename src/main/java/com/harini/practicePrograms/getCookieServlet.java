package com.harini.practicePrograms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class getCookieServlet extends HttpServlet 
{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Cookie[] cookies = null;
		cookies = req.getCookies(); // get an array of cookies 
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		
		Cookie cookie = null;		
		if(cookies!= null)
		{
			for(int i = 0;i<cookies.length;i++)
			{
				cookie = cookies[i];
				out.println("CookieName : " + cookie.getName() + "</br>");
				out.println("CookieValue : " + cookie.getValue() + "</br>");
			}
		}
		else 
		{
			out.println("Cookies not found");
		}
		out.println("</body></html>");	

	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doGet(req,resp);
		
	}


}
