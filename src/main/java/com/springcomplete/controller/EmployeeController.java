package com.springcomplete.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcomplete.model.Employee;
import com.springcomplete.service.EmployeeService;


//combination of @Controller and @ResponseBody
@RestController

//used to specify the global path in the URL
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	
	//used to insert the data 
	@PostMapping("/insert")
	//@RequestBody - Allows us to retrieve the request's body and automatically convert it to Java Object
	public Employee insert(@RequestBody Employee employee){
			return employeeService.insert(employee);
	}

	 
	//Get All the Employee Details
	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	
	//Get An Employee Detail using his/her Id
	@GetMapping("/getAll/{id}")
	//@pathVariable - Used to extract the value from the URL 
	public Employee getById(@PathVariable Integer id) {
		return employeeService.getById(id);
	}	
	
	//update an Existing Employee
	@PutMapping("/update")
	public Employee update(@PathVariable Integer id, @RequestBody Employee employee) {		
		return employeeService.update(id, employee);
	}
	
	//Delete an Employee from the database
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		return employeeService.delete(id);
	}
	
	
}
