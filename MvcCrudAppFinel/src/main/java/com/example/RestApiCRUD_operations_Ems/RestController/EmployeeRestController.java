package com.example.RestApiCRUD_operations_Ems.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApiCRUD_operations_Ems.Entity.Employee;
import com.example.RestApiCRUD_operations_Ems.service.EmployeeService;

@Controller
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService emp;
	
	@GetMapping("/list")
	public  String listEmployees(Model model){
		List<Employee> ems=emp.findall();
		model.addAttribute("employees", ems);
		return "list-emps";
   }
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model themodel) {
		Employee employee=new Employee();
		themodel.addAttribute("employee", employee);
		return "employee-form";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		emp.save(employee);
		return "redirect:/list";
	}
	
	@PostMapping("/employees")
	public Employee addemp(@RequestBody Employee employee) {
		return emp.save(employee);
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int theid,Model themodel ){
		Optional<Employee> theEmployee=emp.findbyId(theid);
		themodel.addAttribute("employee",theEmployee);
		return "employee-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId")int theid){
		emp.deletebyID(theid);
		return "redirect:/list";
		
	}
}
