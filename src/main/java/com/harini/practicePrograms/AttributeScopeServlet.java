package com.harini.practicePrograms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class AttributeScopeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		// Request Attribute scope
		Object counterObject = req.getAttribute("counter");
		int requestCounter = 1;
		if (counterObject != null) {
			requestCounter = (int) counterObject;
			requestCounter++;
		}
		req.setAttribute("counter", requestCounter);
		out.println("request.counter : " + requestCounter);

		// Session Attribute scope
		HttpSession session = req.getSession();
		counterObject = session.getAttribute("counter");
		int sessionCounter = 1;
		if (counterObject != null) {
			sessionCounter = (int) counterObject;
			sessionCounter++;
		}
		session.setAttribute("counter", sessionCounter);
		out.println("session.counter : " + sessionCounter);

		// Application Attribute scope
		ServletContext servletContext = req.getServletContext();
		counterObject = servletContext.getAttribute("counter");
		int applicationCounter = 1;
		if (counterObject != null) {
			applicationCounter = (int) counterObject;
			applicationCounter++;
		}
		servletContext.setAttribute("counter", applicationCounter);
		out.println("application.counter : " + applicationCounter);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
