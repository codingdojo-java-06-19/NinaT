package com.ninatompkin.employeesmanagers.services;

import java.util.List;

import com.ninatompkin.employeesmanagers.models.Employee;
import com.ninatompkin.employeesmanagers.repositories.EmployeeAndManagerRepository;

public class EmployeeAndManagerService {
	private final EmployeeAndManagerRepository empManRepo;
	
	public EmployeeAndManagerService(EmployeeAndManagerRepository empManRepo) {
		this.empManRepo = empManRepo;
	}
	
	public List<Employee> getManagersEmployees(Long employee_id){
		Employee manager = empManRepo.findById(employee_id).orElse(null);
		if (manager.getEmployees() == null) {
			System.out.println("This is just a normal employee, not a manager! They don't have any employees.");
		}
		return manager.getEmployees();
	}
	
	public Employee getMyManager(Long employee_id) {
		Employee employee = empManRepo.findById(employee_id).orElse(null);
		if (employee.getManager() == null) {
			System.out.println("This employee doesn't have a manager! Does this mean...they're the top dog!?");
		}
		return employee.getManager();
	}

}
