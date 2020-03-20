package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeService {

	List<Employee> getempAll();

	long empsave(Employee emp);

}
