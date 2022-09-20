package com.crud.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.crud.employee.exceptions.EmpIdNotFoundException;
import com.crud.employee.model.Employee;
import com.crud.employee.repository.EmployeeRepo;
import com.crud.employee.service.EmplService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	private EmplService empservice;
	
	@MockBean
	private EmployeeRepo erepo;
	
	@Test
	void getAllEmployeesTest() {
		
		when(erepo.findAll()).thenReturn(Stream.of(new Employee(1, "Vikram", "Chennai", "Support"), new Employee(2, "Daniel", "Hyderabad", "IT")).collect(Collectors.toList()));
		assertEquals(2, empservice.getAllEmployees().size());
	}
	
	@Test
	void getByEmployeeIdTest() throws EmpIdNotFoundException {
		
		Employee empl = new Employee();
		empl.setEmpid(3);
		empl.setEname("Lokesh");
		empl.setDepartment("Support");
		empl.setLocation("Chennai");
		when(erepo.findByEmpid(empl.getEmpid())).thenReturn(empl);
		Employee expectedemp = empservice.getbyEmployeeId(empl.getEmpid());
		assertThat(expectedemp).isSameAs(empl);
		
	}
	
	@Test
	public void addEmployeeTest() {
		
		Employee empl = new Employee();
		empl.setEmpid(3);
		empl.setEname("Lokesh");
		empl.setDepartment("Support");
		empl.setLocation("Chennai");
		when(erepo.save(empl)).thenReturn(empl);
		assertEquals(empl,empservice.addEmployee(empl));

	}
	
	@Test
	public void DeleteEmployeebyIdTest() throws EmpIdNotFoundException {
		
		Employee empl = new Employee();
		empl.setEmpid(3);
		empl.setEname("Lokesh");
		empl.setDepartment("Support");
		empl.setLocation("Chennai");
		when(erepo.findByEmpid(empl.getEmpid())).thenReturn(empl);
		empservice.deletebyEmpid(empl.getEmpid());
		verify(erepo).deleteByEmpid(empl.getEmpid());
	}
	
	@Test
	public void EditEmployeebyIdTest() throws EmpIdNotFoundException{
		
		Employee empl = new Employee();
		empl.setEmpid(3);
		empl.setEname("Lokesh");
		empl.setDepartment("Support");
		empl.setLocation("Chennai");
		when(erepo.save(empl)).thenReturn(empl);
		
		Employee newempl = new Employee();
		newempl.setEname("Daniel");
		newempl.setDepartment("Tech");
		newempl.setLocation("Chennai");
		
		when(erepo.findByEmpid(empl.getEmpid())).thenReturn(empl);
		Employee editted  = empservice.editEmployee(empl.getEmpid(), newempl);
		assertEquals(editted,empservice.editEmployee(empl.getEmpid(), newempl));
		
	}
	
	
	
	
}
