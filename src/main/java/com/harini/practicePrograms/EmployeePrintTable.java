package com.harini.practicePrograms;

import java.util.List;

import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harini.employee.jdbc.ConnectionManager;
import com.harini.employee.jdbc.EmployeeDataService;

@SuppressWarnings("serial")
public class EmployeePrintTable extends HttpServlet {

	ConnectionManager connectionManager = new ConnectionManager();
	EmployeeDataService employeeDataService = new EmployeeDataService();

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection connection = null;
		PrintWriter out = resp.getWriter();
		try {
			connection = connectionManager.getConnection();
			String sql = "Select * from employee;";
			List<Map<String, String>> employeeRowData = employeeDataService.executeQueryMap(connection, sql);
			employeeDataService.printTable(employeeRowData);

			Set<String> columnSet = employeeRowData.get(0).keySet(); // get all keys of the map

			for (Map<String, String> row : employeeRowData) {
				out.println("<html> <body> <table> <tr>");
				for (String column : columnSet) {					
					out.println("<td>");
					out.println(row.get(column));
					out.println("</td>");
				}
				out.println("</tr>");
				out.println("</table></body> </html>");

			}

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

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
