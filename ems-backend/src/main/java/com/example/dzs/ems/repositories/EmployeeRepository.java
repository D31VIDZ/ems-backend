package com.example.dzs.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dzs.ems.entites.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
