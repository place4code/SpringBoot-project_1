package com.place4code.springboot.crud_1.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<Employee> getAll() {
		
		//org.hibernate.Session
		Session session = entityManager.unwrap(Session.class);

		//org.hibernate.query.Query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		//execute query
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		//org.hibernate.Session
		Session session = entityManager.unwrap(Session.class);
		
		//return employee
		return session.get(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {

		//get session
		Session session = entityManager.unwrap(Session.class);
		//save or update
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {

		//get session
		Session session = entityManager.unwrap(Session.class);
		//execute
		session.createQuery("delete from Employee where id=:id")
				.setParameter("id", id)
				.executeUpdate();
	}

}
