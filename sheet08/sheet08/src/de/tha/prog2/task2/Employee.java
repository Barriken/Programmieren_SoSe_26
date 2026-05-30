package de.tha.prog2.task2;

public class Employee {
	public Employee(int id, String name, String department, double years) {
		this.department = department;
		this.employeeID = id;
		this.yearsEmployed = years;
		this.name = name;
	}
	
	private int employeeID;
	private String name;
	private String department;
	private double yearsEmployed;
	
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public double getYearsEmployed() {
		return yearsEmployed;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
}
