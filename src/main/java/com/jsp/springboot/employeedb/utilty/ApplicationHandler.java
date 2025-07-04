package com.jsp.springboot.employeedb.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.employeedb.exception.EmployeeNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleEmployeeNotFoundById(EmployeeNotFoundByIdException ex) {
		ErrorStructure<String> errorStructure = new ErrorStructure<String>();
		errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setError("Employee with resquested id is not present in the database");
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
}
