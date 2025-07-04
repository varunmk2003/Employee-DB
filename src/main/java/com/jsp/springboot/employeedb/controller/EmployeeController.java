package com.jsp.springboot.employeedb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.employeedb.entity.Employee;
import com.jsp.springboot.employeedb.service.EmployeeService;
import com.jsp.springboot.employeedb.utility.ResponseStructure;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee employee) {
		Employee employee2 = employeeService.addEmployee(employee);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employee2);
		responseStructure.setMessage("Object has been inserted successfully");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());

		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Employee>>> displayAllEmployee() {

		List<Employee> employees = employeeService.displayAllEmployee();
		ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<List<Employee>>();
		responseStructure.setData(employees);
		responseStructure.setMessage("Employees objects have been successfully fetched");
		responseStructure.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(@PathVariable Integer employeeId) {
		Employee employee = employeeService.findEmployeeById(employeeId);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employee);
		responseStructure.setMessage("Employee object have been successfully fetched");
		responseStructure.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@PostMapping("/delete/id")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(Integer employeeId) {
		Employee employee = employeeService.deleteEmployeebyId(employeeId);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employee);
		responseStructure.setMessage("Employees object has been deleted");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@PostMapping("/update/{employeeId}")
	public ResponseEntity<ResponseStructure<Employee>> updateByEmployeeId(@PathVariable Integer employeeId,
			@RequestBody Employee employee) {
		Employee employee2 = employeeService.updateByEmployeeId(employeeId, employee);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employee2);
		responseStructure.setMessage("the object has been updated");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	@GetMapping("/name/{employeeName}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByEmployeeName(@PathVariable String employeeName) {
		List<Employee> employees = employeeService.findByEmployeeName(employeeName);
		ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<List<Employee>>();
		responseStructure.setData(employees);
		responseStructure.setMessage("Employees objects have been successfully fetched");
		responseStructure.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

}
