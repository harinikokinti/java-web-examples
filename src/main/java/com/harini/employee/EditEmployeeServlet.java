package com.harini.employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harini.employee.jdbc.ConnectionManager;
import com.harini.employee.jdbc.EmployeeDataService;

@SuppressWarnings("serial")
public class EditEmployeeServlet extends HttpServlet {

	ConnectionManager connectionManager = new ConnectionManager();
	EmployeeDataService employeeDataService = new EmployeeDataService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		try {
			Integer Employee_ID = Integer.parseInt(request.getParameter("id"));
			connection = connectionManager.getConnection();
			
				String sql = "Select * from employee where ID = " + Employee_ID;
				List<Employee> employeeToEdit = employeeDataService.executeQuery(connection, sql);
				request.setAttribute("editEmployee", employeeToEdit.get(0));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {

			connectionManager.closeConnection(connection);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/addEmployee.jsp");
		dispatcher.forward(request, response);

		

	}
}