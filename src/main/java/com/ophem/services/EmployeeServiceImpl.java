package com.ophem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ophem.entity.Employee;
import com.ophem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> loadEmployee() {
		
		return repository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return repository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		Optional<Employee> emp = repository.findById(id);
		if(emp.isPresent()) {
			return repository.save(employee);
		}else {
			return null;
		}
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		
		return repository.getById(id);
	}
	@Override
	public void deleteEmployee(Integer id) {
		
		Optional<Employee> employee = repository.findById(id);
		if(employee.isPresent()) {
			repository.deleteById(id);
		}else {
			System.out.println("Employee with id "+ id + " does not exist");
		}

	}


}
