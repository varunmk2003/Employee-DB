package com.jsp.springboot.employeedb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot.employeedb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByEmployeeName(String employeeName);
}
