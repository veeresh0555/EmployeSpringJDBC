package com.example.dao;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeDAO {

	List<Employee> getempAll();

	long empsave(Employee emp);

}
