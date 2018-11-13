package com.harini.practicePrograms;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MyFirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String name  = req.getParameter("names");
		
		PrintWriter out = resp.getWriter();
		
		out.print("Welcome");
		/*
		out.println("<html><body>");
		out.print("My First Name is : " + req.getParameter("first_name"));
		out.print("</br>");
		out.print("My Last Name is : " + req.getParameter("last_name"));
		out.println("</body></html>");
		*/
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
		
		
		
	}

	

}
