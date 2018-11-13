package com.harini.employee.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.harini.employee.Employee;

public class EmployeeDataService {

	public boolean addEmployee(Connection connection, String firstName, String lastName) throws SQLException {

		String sql = "INSERT INTO EMPLOYEE (FIRST_NAME,LAST_NAME) VALUES (?,?)";
		System.out.println("Insert Query : " + sql + " firstname :" + firstName + " lastName : " + lastName);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		int rowsInserted = preparedStatement.executeUpdate();
		return rowsInserted > 0;
	}

	public void editEmployee(Connection connection, int id, String firstName, String lastName) throws SQLException {
		String sql = "UPDATE EMPLOYEE SET FIRST_NAME ='" + firstName + "', LAST_NAME ='" + lastName + "' WHERE ID ="
				+ id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate(sql);
	}

	public void deleteEmployee(Connection connection, int id) throws SQLException {
		String sql = "DELETE FROM EMPLOYEE WHERE ID = " + id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate(sql);

	}

	public List<Employee> executeQuery(Connection connection, String sql) throws SQLException {

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		List<Employee> employeeObjects = new ArrayList<Employee>();

		while (resultSet.next()) {
			Employee employee = new Employee();
			int empId = resultSet.getInt("ID");
			String firstName = resultSet.getString("FIRST_NAME");
			String lastName = resultSet.getString("LAST_NAME");
			employee.setEmpId(empId);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);

			employeeObjects.add(employee);

		}
		return employeeObjects;

	}

	public List<Map<String, String>> executeQueryMap(Connection connection, String sql) throws SQLException {

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		ResultSetMetaData metaData = resultSet.getMetaData();

		List<String> columns = new ArrayList<String>();
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			columns.add(metaData.getColumnName(i));
		}

		List<Map<String, String>> data = new ArrayList<Map<String, String>>();

		while (resultSet.next()) { // Iterates if there are rows of data
			Map<String, String> row = new HashMap<String, String>();
			for (String col : columns) {
				row.put(col, resultSet.getString(col));
			}
			data.add(row);
		}

		resultSet.close();
		statement.close();

		return data;

	}

	public void printTable(List<Map<String, String>> rowData) {
		Set<String> columnSet = rowData.get(0).keySet(); // get all keys of the map

		for (Map<String, String> row : rowData) {
			for (String column : columnSet) {

				System.out.print(row.get(column) + "\t");
			}
			System.out.println();
		}
	}

}