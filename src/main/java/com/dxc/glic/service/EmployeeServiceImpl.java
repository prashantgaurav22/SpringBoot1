package com.dxc.glic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.glic.entity.Department;
import com.dxc.glic.entity.Employee;
import com.dxc.glic.exception.EmployeeException;
import com.dxc.glic.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public static Integer ids;

	public static Integer empid;

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private DepartmentService deptService;

	@Transactional
	@Override
	public Employee add(Employee employee) throws EmployeeException {
		
		if (!(employee.getEmployeeId() != null  && employee.getFirstName() != "" 
				&& employee.getLastName() != "" && employee.getEmail() != ""))
		{
			throw new EmployeeException(
					"All Fields are Mandatory!");
		}
		else if(employee.getEmployeeId()<0 || employee.getEmployeeId()==null)
		{
			throw new EmployeeException(
					"Employee Id should Mandatory & should be greater than 0!");
		}
		
		
		if(employee.getDepartment()==null)
		{
			throw new EmployeeException(
					"Department Id is Mandatory or Incorrect!");
		}
		
		

		else if (employee != null) {
			if (employeeRepo.existsById(employee.getEmployeeId())) {
				throw new EmployeeException(
						"An Employee with the Employee Id " + employee.getEmployeeId() + " already exists!");
			}

			employeeRepo.save(employee);
			ids = employee.getEmployeeId();

		}
		return employee;
	}

	@Transactional
	@Override
	public Employee getEmpId(int employeeId) {
		
		empid = employeeId;
		return employeeRepo.findById(employeeId).orElse(null);
	}

	@Transactional
	@Override
	public List<Employee> getAllEmps() {
		return employeeRepo.findAll();
	}

}
