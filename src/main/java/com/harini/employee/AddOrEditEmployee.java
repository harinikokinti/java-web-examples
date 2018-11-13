package com.harini.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harini.employee.jdbc.ConnectionManager;
import com.harini.employee.jdbc.EmployeeDataService;

@SuppressWarnings("serial")
public class AddOrEditEmployee extends HttpServlet {

	ConnectionManager connectionManager = new ConnectionManager();
	EmployeeDataService employeeDataService = new EmployeeDataService();

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		
		try {
			connection = connectionManager.getConnection(); // get mysql jdbc connection

			String firstName = req.getParameter("first_name");
			String lastName = req.getParameter("last_name");
			String id = req.getParameter("id");
			String action = req.getParameter("action");
			PrintWriter out = resp.getWriter();	

			if (id != null && !"".equals(id.trim()) && action.equals("edit")) {   // edit employee data
				Integer Empid = Integer.parseInt(id);
				employeeDataService.editEmployee(connection, Empid, firstName, lastName); // updates employee data
			} else if (id != null && !"".equals(id.trim()) && action.equals("delete")) { 
				Integer Empid = Integer.parseInt(id);
				employeeDataService.deleteEmployee(connection, Empid); // deletes the employee record from the database
			} else {
				employeeDataService.addEmployee(connection, firstName, lastName); // adds new employee
			}  

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connectionManager.closeConnection(connection);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/ShowEmployeesList");
		dispatcher.forward(req, resp); 
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
