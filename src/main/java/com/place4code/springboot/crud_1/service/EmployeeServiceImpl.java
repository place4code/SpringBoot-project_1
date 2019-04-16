package com.place4code.springboot.crud_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.place4code.springboot.crud_1.dao.EmployeeRepository;
import com.place4code.springboot.crud_1.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {

		//find employee
		Optional<Employee> result = employeeRepository.findById(id);
		
		//employee exists
		if(result.isPresent()) return result.get();
		
		//employee doesn't exist
		throw new RuntimeException("Didn't find with id: " + id);
		
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
