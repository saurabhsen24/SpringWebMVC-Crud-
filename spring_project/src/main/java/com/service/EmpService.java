package com.service;

import java.util.List;

import com.model.Employee;

public interface EmpService {

	public void add(Employee employee);
	
	public void delete(int id);
	
	public void update(Employee employee);
	
	public Employee getEmpById(int id);
	
	public List<Employee> getEmployees();
}
