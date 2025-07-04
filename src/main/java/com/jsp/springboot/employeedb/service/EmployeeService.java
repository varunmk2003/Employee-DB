package com.jsp.springboot.employeedb.service;

import java.util.List;
import java.util.Optional;

import com.jsp.springboot.employeedb.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> displayAllEmployee();

	public Employee findEmployeeById(Integer employeeId);

	public Employee deleteEmployeebyId(Integer employeeId);

	public Employee updateByEmployeeId(Integer employeeId,Employee employee);
	
	public List<Employee> findByEmployeeName(String employeeName);

}
