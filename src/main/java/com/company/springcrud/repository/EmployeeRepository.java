package com.company.springcrud.repository;

import com.company.springcrud.entity.Employee;
import org.springframework.data.repository.CrudRepository;
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
