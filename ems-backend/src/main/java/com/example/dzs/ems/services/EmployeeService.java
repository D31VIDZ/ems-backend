package com.example.dzs.ems.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dzs.ems.dots.EmployeeDTO;
import com.example.dzs.ems.entites.Employee;
import com.example.dzs.ems.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	public List<Employee> getAll() {
		List<Employee> employes = repository.findAll();
		return employes;
	}
	
	public Optional<Employee> getById(Long id) throws Exception{
		Optional<Employee> opEmployee = repository.findById(id);
		
		if(opEmployee.isEmpty()) {
			throw new Exception ("ERRO! Employee nao encontrado"); 
		}
		return opEmployee;
	}
	
	public Employee createEmployee(EmployeeDTO employee) {
		
		Employee newEmployee = new Employee(employee);
		repository.save(newEmployee);
		
		return newEmployee;
	}
	
	public Employee updateEmployee(Long id, EmployeeDTO upEmployee) throws Exception {
		
		Employee employee = repository.findById(id).orElseThrow(
													() -> new Exception("ERRO! Employee nao encontrado")
													); 
		
		employee.setFirstName(upEmployee.firstName());
		employee.setLastName(upEmployee.lastName());
		employee.setEmail(upEmployee.email());
		repository.save(employee);
		
		return employee;
	}
	
	public Optional<Employee> delete(Long id) throws Exception {
		Optional<Employee> opEmployee = this.getById(id);
		
		if(opEmployee.isEmpty()) {
			throw new Exception("ERRO! Employee nao encontrado"); 
		}
		repository.deleteById(id);
		
		return opEmployee;
	}
}