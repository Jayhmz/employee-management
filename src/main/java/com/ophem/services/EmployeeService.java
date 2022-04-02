package com.ophem.services;

import java.util.List;

import com.ophem.entity.Employee;

public interface EmployeeService{
	
	List<Employee> loadEmployee();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id);
	
	Employee updateEmployee(Employee employee, Integer id);
	
	void deleteEmployee(Integer id);
}
