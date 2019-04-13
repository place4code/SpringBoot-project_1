package com.place4code.springboot.crud_1.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.place4code.springboot.crud_1.entity.Employee;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
	
	//define EntityManager
	private EntityManager entityManager;
	
	//constructor injection
	@Autowired
	public EmployeeDAOimpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public List<Employee> getAll() {
		
		//org.hibernate.Session
		Session session = entityManager.unwrap(Session.class);

		//org.hibernate.query.Query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		//execute query
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

}
