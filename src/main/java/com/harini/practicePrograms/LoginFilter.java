package com.harini.practicePrograms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public  class LoginFilter implements Filter{
	
	public void init(FilterConfig config)
	{
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain)throws IOException, ServletException
	{
		PrintWriter out = resp.getWriter();
		String password = req.getParameter("Password");
		
		if(password.equals("harini"))
		{

//			chain.doFilter(req,resp);
			out.println("Success");
		}
		else
		{
			out.println("Incorrect Password");
		}
	
	}
	
	public void destroy()
	{
		
	}
}
