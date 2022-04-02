package com.ophem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ophem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
