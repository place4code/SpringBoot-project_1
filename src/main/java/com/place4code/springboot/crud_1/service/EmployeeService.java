package com.place4code.springboot.crud_1.service;

import java.util.List;

import com.place4code.springboot.crud_1.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);

}
