package com.dxc.glic.service;

import java.util.List;

import com.dxc.glic.entity.Employee;
import com.dxc.glic.exception.EmployeeException;

public interface EmployeeService {

	Employee add(Employee employee) throws EmployeeException;// add method

	List<Employee> getAllEmps();// fetch all employees

	Employee getEmpId(int employeeId);// search

}
