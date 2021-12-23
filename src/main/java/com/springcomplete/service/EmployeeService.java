package com.springcomplete.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springcomplete.exception.ResourceNotFoundException;
import com.springcomplete.model.Employee;
import com.springcomplete.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;
	
	public Employee insert(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	public Employee getById(Integer id) {
		Optional<Employee> existingEmployee = employeeRepository.findById(id);
		if(existingEmployee.isPresent()) {
			return existingEmployee.get();
		}
		//Need to check with Exception
		else {
			throw new ResourceNotFoundException("Employee","id", id);
		}
	}
	
	public Employee update(Integer id,Employee updateEmployee) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if(optionalEmployee.isPresent()) {
			Employee existingEmployee = optionalEmployee.get();
			existingEmployee.setFirstName(updateEmployee.getFirstName());
			existingEmployee.setLastName(updateEmployee.getLastName());
			existingEmployee.setEmail(updateEmployee.getEmail());
			employeeRepository.save(existingEmployee);
			return existingEmployee;
		}
		else {
			throw new ResourceNotFoundException("Employee", "id", id);
		}
	}
	
	public String delete(Integer id) {
		Optional<Employee> existingEmployee = employeeRepository.findById(id);
		System.out.println(existingEmployee);
		if(existingEmployee.isPresent()) {
			employeeRepository.delete(existingEmployee.get());
			return "Employee deleted";
		}
		else {
			throw new ResourceNotFoundException("Employee","id", id);
		}
	}
}
