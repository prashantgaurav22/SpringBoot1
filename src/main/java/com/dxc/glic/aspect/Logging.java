package com.dxc.glic.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxc.glic.controller.EmployeeController;
import com.dxc.glic.entity.Transaction;
import com.dxc.glic.service.EmployeeServiceImpl;
import com.dxc.glic.service.TransactionServiceImpl;

@Component
@Aspect
public class Logging {

	@Autowired
	TransactionServiceImpl tsimpl;

	@Autowired
	EmployeeServiceImpl eimpl;

	@Autowired
	EmployeeController empc;

	@Before("execution(* com.dxc.glic.controller.EmployeeController.registration(..))")
	public void crossCutFunction1(JoinPoint jp) {
		System.out.println("Add New is Excecute: " + jp.getSignature().getName());

	}

	@AfterReturning("execution(* com.dxc.glic.controller.EmployeeController.doNewRegistration(..))")
	public void crossCutFunction2(JoinPoint jp) {
		System.out.println("Add New is Done: " + jp.getSignature().getName());
		Transaction obj = new Transaction();
		if(eimpl.ids!=null)
		{
			obj.setEmployeeId(eimpl.ids);
			obj.setTransactionType("Registration");
			obj.setTimeStamp(LocalDateTime.now());
			tsimpl.addTrans(obj);
		}
		
	}

	@Before("execution(* com.dxc.glic.controller.EmployeeController.search(..))")
	public void crossCutFunction3(JoinPoint jp) {
		System.out.println("View is Excecute: " + jp.getSignature().getName());

	}

	@AfterReturning("execution(* com.dxc.glic.controller.EmployeeController.getEmp(..))")
	public void crossCutFunction4(JoinPoint jp) {
		System.out.println("View is Done: " + jp.getSignature().getName());

		Transaction obj2 = new Transaction();
		if(eimpl.empid!=null)
		{
			obj2.setEmployeeId(eimpl.empid);
			obj2.setTransactionType("View");
			obj2.setTimeStamp(LocalDateTime.now());
			tsimpl.addTrans(obj2);
		}
		
	}

}
