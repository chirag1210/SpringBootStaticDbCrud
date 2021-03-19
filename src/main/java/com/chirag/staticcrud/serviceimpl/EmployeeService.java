package com.chirag.staticcrud.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.chirag.staticcrud.model.Employee;
import com.chirag.staticcrud.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	public static final Map<String, Employee> staticDb = new HashMap<>();

	static {
		Employee employee = new Employee();
		employee.setEmpId("1");
		employee.setName("Chirag");
		employee.setAddress("Pune");
		employee.setPhone("9595959595");
		staticDb.put(employee.getEmpId(), employee);
	}

	@Override
	public void createEmployee(Employee employee) {
		staticDb.put(employee.getEmpId(), employee);
	}

	@Override
	public Employee getEmployeeByEmpId(String empId) {
	    Employee emp = staticDb.get(empId);
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		staticDb.put(emp.getEmpId(), emp);
		Employee employee = staticDb.get(emp.getEmpId());
		return employee;
	}

	@Override
	public void deleteEmployee(String empId) {
		staticDb.remove(empId);
	}

}
