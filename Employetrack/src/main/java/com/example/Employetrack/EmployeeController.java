package com.example.Employetrack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	
	@GetMapping("/getmessage")
	public String method1() {
		
		return "first";
	}
	
	
	
}
