package com.place4code.springboot.crud_1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.place4code.springboot.crud_1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
