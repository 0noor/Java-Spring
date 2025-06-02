package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		// get employee from DB
		List<Employee> theEmployee = employeeService.findAll();
		
		//add to the spring model
		
		theModel.addAttribute("employees", theEmployee);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	private String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	private String showFormForUpdat(@RequestParam("employeeId") int theId,Model theModel) {
		
		//get the employee from the service 
		Employee theEmployee = employeeService.findById(theId);
		//set employee in the model to prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		//send over to our form
		
		
		return "employee/employee-form";	
		}
	
	@PostMapping("/save")
	private String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		//save employee 
		
		employeeService.save(theEmployee);
		//redirect to prevent dublicate submission
		
		return "redirect:/employees/list";
	}
}
