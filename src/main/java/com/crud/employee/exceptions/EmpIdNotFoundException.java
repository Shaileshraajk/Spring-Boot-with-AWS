package com.crud.employee.exceptions;

public class EmpIdNotFoundException extends Exception{
	public EmpIdNotFoundException(int id) {
		super("Employee Id: "+id+", not found");
	}

}
