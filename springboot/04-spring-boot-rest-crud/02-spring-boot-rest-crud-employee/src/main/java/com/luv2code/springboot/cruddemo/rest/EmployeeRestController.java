package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {


	
	private EmployeeService employeeService;
	
	private ObjectMapper objectMapper;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper) {
		
		employeeService = theEmployeeService;
		objectMapper = theObjectMapper;
	}
	
	//explose /employees and return list of employees
	
	@GetMapping("/employees")
		public List<Employee> findAll(){
			return employeeService.findAll();
		}


	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
	
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found");
		}
		
		return theEmployee;
	}
	
	// add mapping for post /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		//just incase they pass id in json ..set id to zero
		//this is to force a save of a new item instead of an update
		
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
		
			
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		//find employee
		Employee dbEmployee = employeeService.save(theEmployee);
		
		//return employee
				return dbEmployee;
		
	}
	
	@PatchMapping("/employees/{employeeId}")
	public Employee patchEmployee(@PathVariable int employeeId) {
		
		Employee dbEployee = employeeService.findById(employeeId)
				
		
		return 
	}
}
