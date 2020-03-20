package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {

	
	@Autowired
	EmployeeService empservice;
	
	
	
	
	@GetMapping("/getString")
	public String method1() {
		
		return "first";
	}
	
	
	
	
	

 @GetMapping("/getAllemp")
  public List<Employee> getempAll(){
	
	  List<Employee> listofemployees=empservice.getempAll();
	  
	  	return listofemployees;
  	}
 
 
 
 @PostMapping("/empsave")
   public ResponseEntity<?> empsave(@RequestBody Employee emp){
	   long result=empservice.empsave(emp);
	  return new ResponseEntity<Long>(result, HttpStatus.OK);
   }
 
 
 
 
	
	
	
	
	
}
