package com.example.RestApiCRUD_operations_Ems.service;

import java.util.List;
import java.util.Optional;

import com.example.RestApiCRUD_operations_Ems.Entity.Employee;

public interface EmployeeService {
		
		public List<Employee> findall();
		
		public Optional<Employee> findbyId(int id);

		public Employee save(Employee employee);
		
		public void deletebyID(int id);

	}


