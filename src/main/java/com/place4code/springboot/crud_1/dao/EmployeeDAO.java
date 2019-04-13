package com.place4code.springboot.crud_1.dao;

import java.util.List;

import com.place4code.springboot.crud_1.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getAll();
	
}
