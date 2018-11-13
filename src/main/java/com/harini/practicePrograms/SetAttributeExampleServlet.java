package com.harini.practicePrograms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SetAttributeExampleServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		
		// Get Request Attribute objects and print
		ArrayList<String> fruitsListObjects = (ArrayList<String>) req.getAttribute("fruits");
		out.println("Hi");
		out.println(fruitsListObjects);

		// Get Session Attribute Objects and print
		HttpSession session = req.getSession();
		ArrayList<String> vegetablesListObjects = (ArrayList<String>) session.getAttribute("vegetables");
		out.println(vegetablesListObjects);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doGet(req, resp);
	}

}
