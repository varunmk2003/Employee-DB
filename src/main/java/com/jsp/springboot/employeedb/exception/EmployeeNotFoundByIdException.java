package com.jsp.springboot.employeedb.exception;

public class EmployeeNotFoundByIdException extends RuntimeException {

	private String message = "Employee object was not found";

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
