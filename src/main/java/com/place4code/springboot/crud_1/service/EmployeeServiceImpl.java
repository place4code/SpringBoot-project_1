package com.place4code.springboot.crud_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.place4code.springboot.crud_1.dao.EmployeeDAO;
import com.place4code.springboot.crud_1.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeDAO.getAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(id);
	}

}
