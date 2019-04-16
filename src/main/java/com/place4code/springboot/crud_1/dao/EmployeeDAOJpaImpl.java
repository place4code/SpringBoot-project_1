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

		//find and return
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {

		//save or update
		entityManager.merge(employee);
	}

	@Override
	public void deleteById(int id) {

		//short version: query -> parameter -> update
		entityManager.createQuery("delete from Employee where id=:id")
				 	 .setParameter("id", id)
					 .executeUpdate();
	}

}
