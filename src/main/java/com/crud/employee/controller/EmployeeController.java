package com.crud.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.employee.exceptions.EmpIdNotFoundException;
import com.crud.employee.exceptions.EmployeeNameNotFoundException;
import com.crud.employee.model.Employee;
import com.crud.employee.service.EmplService;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmplService empservice;
	 
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll(){
		 return new ResponseEntity<List<Employee>>(empservice.getAllEmployees(),HttpStatus.OK);
	}
	
	@GetMapping("/getById")
    public ResponseEntity<Employee> getById(@RequestParam(required = true) int id) throws EmpIdNotFoundException{
     return new ResponseEntity<Employee>(empservice.getbyEmployeeId(id),HttpStatus.OK);
    }
	
	@GetMapping("/searchEmployee")
    public ResponseEntity<List<Employee>> searchEmployeebyName(@RequestParam(required = true) String ename) throws EmployeeNameNotFoundException{
        List<Employee> employees = empservice.searchbyEmplName(ename);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
	
	
	@PostMapping("/add")
	public ResponseEntity<Employee> add(@RequestBody Employee el){
		Employee emprsp = empservice.addEmployee(el);
		return new ResponseEntity<>(emprsp,HttpStatus.OK);

	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Employee> editInstitute(@PathVariable("id") int id, @RequestBody Employee el) throws EmpIdNotFoundException{
		
		Employee edittedemp = empservice.editEmployee(id, el);

		return new ResponseEntity<Employee>(edittedemp,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@Transactional
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) throws EmpIdNotFoundException{
		Employee eld = empservice.getbyEmployeeId(id);
		empservice.deletebyEmpid(eld.getEmpid());
		return  new ResponseEntity<String>("Employee Details Deleted Successfully", HttpStatus.OK);
	}
	
	
	

}
