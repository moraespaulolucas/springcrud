package com.company.springcrud.controller;

import com.company.springcrud.dto.EmployeeDTO;
import com.company.springcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path="/add")
    public ResponseEntity<URI> postEmployee(@RequestBody @Validated EmployeeDTO employeeDTO){
        return ResponseEntity.created(employeeService.postEmployee(employeeDTO)).build();
    }

    @GetMapping(path = "/list")
    public ResponseEntity<Page<EmployeeDTO>> getProducts(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(employeeService.getEmployees(pageable));
    }
}

