package com.place4code.springboot.crud_1.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.place4code.springboot.crud_1.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Employee> getAll() {

		//short version query -> result
		return entityManager.createQuery("from Employee", Employee.class).getResultList();

	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
