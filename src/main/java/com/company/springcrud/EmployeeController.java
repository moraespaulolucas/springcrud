package com.company.springcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewEmployee(@RequestParam String name, @RequestParam Integer age, @RequestParam String department) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setDepartment(department);
        return "Saved";
    }

    @GetMapping(path = "/list")
    public @ResponseBody Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

