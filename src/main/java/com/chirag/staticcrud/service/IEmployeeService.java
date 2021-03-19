package com.chirag.staticcrud.service;

import com.chirag.staticcrud.model.Employee;

public interface IEmployeeService {

	public void createEmployee(Employee employee);
	
	public Employee getEmployeeByEmpId(String empId);
	
	public Employee updateEmployee(Employee emp);
	
	public void deleteEmployee(String empId);
}
