package com.jsp.springboot.employeedb.serviceimp_lementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot.employeedb.entity.Employee;
import com.jsp.springboot.employeedb.exception.EmployeeNotFoundByIdException;
import com.jsp.springboot.employeedb.repository.EmployeeRepository;
import com.jsp.springboot.employeedb.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public List<Employee> displayAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		if (employees.isEmpty()) {
			return null;
		} else {
			return employees;
		}
	}

	@Override
	public Employee findEmployeeById(Integer employeeId) {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if (optional.isEmpty()) {
			throw new EmployeeNotFoundByIdException();
		} else {
			return optional.get();
		}
	}

	@Override
	public Employee deleteEmployeebyId(Integer employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		if (employeeRepository.existsById(employeeId)) {
			employeeRepository.deleteById(employeeId);
			return employee;
		} else {
			throw new EmployeeNotFoundByIdException();
		}
	}

	@Override
	public Employee updateByEmployeeId(Integer employeeId, Employee employee) {

		if (employeeRepository.existsById(employeeId)) {
			Employee existEmployee = employeeRepository.findById(employeeId).get();
			employee.setEmployeeId(existEmployee.getEmployeeId());
			employeeRepository.save(employee);
			return employee;
		} else {
			throw new EmployeeNotFoundByIdException();
		}
	}

	@Override
	public List<Employee> findByEmployeeName(String employeeName) {
		List<Employee> employees = employeeRepository.findByEmployeeName(employeeName);
		if (employees.isEmpty()) {
			return null;
		} else {
			return employees;
		}

	}

}
