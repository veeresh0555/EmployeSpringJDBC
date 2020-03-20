package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empdao;
	
	
	@Override
	public List<Employee> getempAll() {
		return empdao.getempAll();
	}


	@Override
	public long empsave(Employee emp) {
		
		return empdao.empsave(emp);
	}

}
