package com.place4code.springboot.crud_1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.place4code.springboot.crud_1.entity.Employee;
import com.place4code.springboot.crud_1.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	
	//get one Employee by ID
	@GetMapping("/employees/{id}")
	public Employee getById(@PathVariable int id) {
		
		//get employee
		Employee tempEmployee = employeeService.findById(id);
		//if null = doesn't exist
		if(tempEmployee == null) throw new RuntimeException("Employee not found");
		
		return tempEmployee;
	}
	
	//create a new employee
	@PostMapping("/employees")
	public Employee addNew(@RequestBody Employee tempEmployee) {

		tempEmployee.setId(0);
		employeeService.save(tempEmployee);
		
		return tempEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee tempEmployee) {
		
		//update with id
		employeeService.save(tempEmployee);
		return tempEmployee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		//get employee
		Employee tempEmployee = employeeService.findById(id);
		//if null = doesn't exist
		if(tempEmployee == null) throw new RuntimeException("Employee not found");
		//delete		
		employeeService.deleteById(id);
		
		return "Deleted!, id: " + id;
		
	}
	
	
}
