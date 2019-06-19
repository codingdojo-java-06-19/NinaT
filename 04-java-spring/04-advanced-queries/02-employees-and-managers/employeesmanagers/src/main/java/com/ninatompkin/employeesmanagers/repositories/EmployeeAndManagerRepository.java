package com.ninatompkin.employeesmanagers.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninatompkin.employeesmanagers.models.Employee;

@Repository
public interface EmployeeAndManagerRepository extends CrudRepository<Employee, Long>{

}
