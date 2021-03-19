package com.chirag.staticcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chirag.staticcrud.model.Employee;
import com.chirag.staticcrud.serviceimpl.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/employee/create")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {

		employeeService.createEmployee(employee);
		return new ResponseEntity<Object>("Successfully created employee", HttpStatus.OK);
	}

	@GetMapping(value = "/employee/getEmployee/{empId}")
	public ResponseEntity<Object> getEmployeeByEmpId(@PathVariable String empId) {
			
		Employee response = null;
		response = employeeService.getEmployeeByEmpId(empId);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/employee/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp) {

		Employee response = null;
		response = employeeService.updateEmployee(emp);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/employee/delete/{empId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String empId) {

		employeeService.deleteEmployee(empId);
		return new ResponseEntity<Object>("Successfully deleted employee", HttpStatus.OK);
	}

}
