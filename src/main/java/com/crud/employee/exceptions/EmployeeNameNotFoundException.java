package com.crud.employee.exceptions;

public class EmployeeNameNotFoundException extends Exception{
	public EmployeeNameNotFoundException(String name) {
		super("Employee Name: "+name+", not found");
	}

}
