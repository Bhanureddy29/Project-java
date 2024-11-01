package com.example.RestApiCRUD_operations_Ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestApiCRUD_operations_Ems.DataJPA.EmployeeRepositry;
import com.example.RestApiCRUD_operations_Ems.Entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepositry employeeService;

	@Override
	public List<Employee> findall() {
		return employeeService.findAll();
	}

	@Override
	public Optional<Employee> findbyId(int id) {
		return employeeService.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeService.save(employee);
	}

	@Override
	@Transactional
	public void deletebyID(int id) {
		employeeService.deleteById(id);
	}

	

}
