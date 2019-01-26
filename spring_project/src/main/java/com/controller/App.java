package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Employee;
import com.service.EmpService;

@Controller
public class App {

	@Autowired
	private EmpService empService;
	
	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command",new Employee());
		return "empform";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Employee emp) {
		empService.add(emp);
		return "redirect:/viewemp";
	}
	
	
	@RequestMapping("/viewemp")
	public String viewemp(Model m) {
		List<Employee> employees = empService.getEmployees();
		m.addAttribute("list", employees);
		return "viewemp";
	}
	

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id,Model m) {
		Employee emp = empService.getEmpById(id);
		m.addAttribute("command",emp);
		return "empeditform";
	}
	
	
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("emp")Employee emp) {
		empService.update(emp);
		return "redirect:/viewemp";
	}
	
	@RequestMapping(value = "/deleteemp/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		empService.delete(id);
		return "redirect:/viewemp";
	}
  
}

