package com.ophem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ophem.entity.Employee;
import com.ophem.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/")
	public String listOfEmployee(Model model) {
		
		model.addAttribute("employees" , empService.loadEmployee());
		Employee employee =  new Employee();
		model.addAttribute("employee", employee);

		return "pages/homepage";
		
	}
	
	@PostMapping("create-employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		empService.saveEmployee(employee);
		
		return "redirect:/";
	}
	
	@GetMapping("/employee/edit/{id}")
	public String editEmployee(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("employee",empService.getEmployeeById(id));
		
		return "pages/edit-employee";
	}
	
	@PostMapping("/update-employee/{id}")
	public String updateEmployee(@PathVariable("id") Integer id, @ModelAttribute("employee") Employee employee) {
		
		empService.updateEmployee(employee, id);
		
		return "redirect:/";
	}
	@GetMapping("/delete-employee/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id, @ModelAttribute("employee") Employee employee) {
		
		empService.deleteEmployee(id);
		
		return "redirect:/";
	}
}
