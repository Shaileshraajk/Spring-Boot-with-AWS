package com.crud.employee.service;

import java.util.List;

import com.crud.employee.exceptions.EmpIdNotFoundException;
import com.crud.employee.exceptions.EmployeeNameNotFoundException;
import com.crud.employee.model.Employee;

public interface EmplService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getbyEmployeeId(int id) throws EmpIdNotFoundException;
	
	public List<Employee> searchbyEmplName(String ename) throws EmployeeNameNotFoundException;
	
	public Employee addEmployee(Employee el);
	
	public int deletebyEmpid(int id) throws EmpIdNotFoundException;
	
	public Employee saveEmployee(Employee el);
	
	public Employee editEmployee (int id, Employee el) throws EmpIdNotFoundException;
	
		

}
