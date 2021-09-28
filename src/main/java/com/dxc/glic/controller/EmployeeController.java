package com.dxc.glic.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.glic.entity.Department;
import com.dxc.glic.entity.Employee;
import com.dxc.glic.entity.Transaction;
import com.dxc.glic.exception.EmployeeException;
import com.dxc.glic.service.DepartmentService;
import com.dxc.glic.service.EmployeeService;
import com.dxc.glic.service.TransactionService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private TransactionService transService;

	public Integer id;

	@GetMapping({ "", "/", "/home" })
	public ModelAndView homePage() {
		return new ModelAndView("home");
	}

	@PostMapping("/view")
	public ModelAndView getEmp(@RequestParam @ModelAttribute("employeeId") Integer employeeId) throws EmployeeException {
		ModelAndView mv = new ModelAndView();

		if(employeeId==null) {
			throw new EmployeeException("Please Enter Employee Id is Mandatory!");
			
		}
		
		Employee emp = employeeService.getEmpId(employeeId);
		
		if (emp == null) {
			throw new EmployeeException("An Employee with the EmpId " + employeeId + " doesnt exists!");

		}
		Transaction td = transService.getByDateTime(employeeId);
		emp.setTimeStamp(td.getTimeStamp());
		id = emp.getEmployeeId();
		return new ModelAndView("viewEmployeeDetails", "emp", emp);
	}

	@GetMapping("/reg")
	public ModelAndView registration() {
		return new ModelAndView("empRegisterPage");
	}

	@GetMapping("/search")
	public ModelAndView search() {
		ModelAndView mv;
		mv = new ModelAndView("empSearchPage");
		return mv;
	}

	

	@PostMapping("/add")
	public ModelAndView doNewRegistration(@Valid @ModelAttribute("emp") Employee emp, BindingResult result)
			throws EmployeeException {
		ModelAndView mv;
	

		/*if (emp.getEmployeeId() == null  || emp.getEmail() == null
				|| emp.getFirstName() == null || emp.getlName() == null ||
				emp.getDepartment()==null) {
			msg2 = msg2+"All Fields Are Mandatory,";
			mv = new ModelAndView("validations", "msg", msg2);
		}		*/	
		

		{
			Integer eid = emp.getEmployeeId();
			employeeService.add(emp);
			Employee e = employeeService.getEmpId(eid);
			mv = new ModelAndView("successPage", "emp", e);
		}
		return mv;
	}
	
	
}
