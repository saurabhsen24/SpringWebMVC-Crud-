package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmpDao;
import com.model.Employee;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao empDao;
	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		empDao.insert(employee);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		empDao.delete(id);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		empDao.update(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployees();
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return empDao.getEmpById(id);
	}

}
