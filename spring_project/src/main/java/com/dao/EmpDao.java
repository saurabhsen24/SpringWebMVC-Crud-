package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmpDao {

	public void insert(Employee employee);
	
	public void delete(int id);
	
	public void update(Employee employee);
	
	public List<Employee> getAllEmployees();

	public Employee getEmpById(int id);
	
}
