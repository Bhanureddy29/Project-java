package com.example.RestApiCRUD_operations_Ems.DataJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestApiCRUD_operations_Ems.Entity.Employee;

@Repository
public interface EmployeeRepositry extends JpaRepository<Employee,Integer> {

}
