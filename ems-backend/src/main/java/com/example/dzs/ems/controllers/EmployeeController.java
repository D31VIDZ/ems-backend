package com.example.dzs.ems.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dzs.ems.dots.EmployeeDTO;
import com.example.dzs.ems.entites.Employee;
import com.example.dzs.ems.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> employees = service.getAll();
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getById(@PathVariable Long id) throws Exception{
		Optional<Employee> opEmployee = service.getById(id);
		
		return ResponseEntity.ok(opEmployee);
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employe){
		Employee newEmployee = service.createEmployee(employe);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDTO upEmployee) throws Exception{
		Employee employee = service.updateEmployee(id, upEmployee);
		
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws Exception{
		service.delete(id);
		return ResponseEntity.ok("employee deletado com sucesso!");
		 
	}
}
