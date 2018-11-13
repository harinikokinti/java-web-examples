package com.harini.employee;

public class Employee {
	private int empId;
	private String firstName;
	private String lastName;
	/*
	Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;		
	} */
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public int getEmpId() {
		return empId;
	}	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

}
