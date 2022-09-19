package com.company.springcrud.service;

import com.company.springcrud.dto.EmployeeDTO;
import com.company.springcrud.dto.EmployeeGetByIdDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public interface EmployeeService {
    URI postEmployee(EmployeeDTO employeeDTO);
    Page<EmployeeDTO> getEmployees(Pageable pageable);
    EmployeeGetByIdDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDTO);
    void deleteEmployeeById(Long id);
}
