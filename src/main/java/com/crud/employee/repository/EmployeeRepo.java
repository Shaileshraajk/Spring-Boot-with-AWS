package com.crud.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.employee.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	Employee findByEmpid(int empid);
	
	List<Employee> findByEnameContaining(String ename);
	
	int deleteByEmpid(int empid);

}
