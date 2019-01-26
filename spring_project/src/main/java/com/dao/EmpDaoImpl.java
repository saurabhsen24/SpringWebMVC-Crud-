package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public class EmpDaoImpl implements EmpDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_QUERY = "INSERT INTO EMP99(name,salary,designation) values(?,?,?)";
	private static final String DELETE_QUERY = "DELETE from EMP99 where id = ?";
	private static final String SELECT_ALL = "SELECT * from EMP99";
	private static final String UPDATE_QUERY = "UPDATE EMP99 SET name = ?,salary = ?, designation = ? where id = ?"; 
	private static final String SELECT_EMP = "SELECT * from EMP99 WHERE id = ?";
	@Override
	public void insert(Employee employee) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(INSERT_QUERY,new Object[] {employee.getName(),employee.getSalary(),employee.getDesignation()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE_QUERY,id);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(UPDATE_QUERY,new Object[] {employee.getName(),employee.getSalary(),employee.getDesignation(),employee.getId()});
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(SELECT_ALL);
		for(Map<String,Object> empRow : empRows) {
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			employee.setName(String.valueOf(empRow.get("name")));
			employee.setDesignation(String.valueOf(empRow.get("designation")));
			employee.setSalary(Float.parseFloat(String.valueOf(empRow.get("salary"))));
			employeeList.add(employee);
		}
		
		return employeeList;
	}
	
	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(SELECT_EMP,id);
		for(Map<String,Object> empRow : empRows) {
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			employee.setName(String.valueOf(empRow.get("name")));
			employee.setDesignation(String.valueOf(empRow.get("designation")));
			employee.setSalary(Float.parseFloat(String.valueOf(empRow.get("salary"))));
			employeeList.add(employee);
		}
		
		return employeeList.get(0);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	

}
