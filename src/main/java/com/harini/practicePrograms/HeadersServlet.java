package com.harini.practicePrograms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeadersServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html> <body> <table>");
		
		
		Enumeration<String> headerNames = req.getHeaderNames();
		
		while(headerNames.hasMoreElements()) 
		{
			String paramName = headerNames.nextElement();
			String paramValue = req.getHeader(paramName);
			out.println("<tr><td>" + paramName + "</td>");
			out.println("<td>" + paramValue + "</td></tr>");
		}
		
		out.println("</table> </body> </html>");
		
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	doGet(req,resp);
	}

}
