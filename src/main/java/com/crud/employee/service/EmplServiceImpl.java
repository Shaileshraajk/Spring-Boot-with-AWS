package com.crud.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.employee.exceptions.EmpIdNotFoundException;
import com.crud.employee.exceptions.EmployeeNameNotFoundException;
import com.crud.employee.model.Employee;
import com.crud.employee.repository.EmployeeRepo;

@Service
public class EmplServiceImpl implements EmplService{
	
	@Autowired
	private EmployeeRepo erepo;

	@Override
	public List<Employee> getAllEmployees() {
		return erepo.findAll();
	}

	@Override
	public Employee getbyEmployeeId(int id) throws EmpIdNotFoundException{
		if(erepo.findByEmpid(id)!=null) {
			return erepo.findByEmpid(id);
		}
		throw new EmpIdNotFoundException(id);
	}

	@Override
	public List<Employee> searchbyEmplName(String ename) throws EmployeeNameNotFoundException{
		List<Employee> employees = new ArrayList<>();
		erepo.findByEnameContaining(ename).forEach(employees::add);
		if(employees.isEmpty()) {
			throw new EmployeeNameNotFoundException(ename);
			
		}
		return employees;
		
	}

	@Override
	public Employee addEmployee(Employee el) {
		return erepo.save(el);
	}

	@Override
	public int deletebyEmpid(int id)  throws EmpIdNotFoundException {
		if(erepo.findByEmpid(id)!=null) {
			return erepo.deleteByEmpid(id);
			
		}
		throw new EmpIdNotFoundException(id);
		
	}

	@Override
	public Employee saveEmployee(Employee el) {
		return erepo.save(el);
	}

	@Override
	public Employee editEmployee(int id, Employee el) throws EmpIdNotFoundException {
		if(erepo.findByEmpid(id)!=null) {
			Employee empdt = erepo.findByEmpid(id);
			empdt.setEname(el.getEname());
			empdt.setDepartment(el.getDepartment());
			empdt.setLocation(el.getLocation());
			
			Employee edittedemp = erepo.save(empdt);
			return edittedemp;
			
		}
		throw new EmpIdNotFoundException(id);
	}


}
