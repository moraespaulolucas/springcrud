package com.company.springcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public @ResponseBody Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Employee> getEmployeeById(@PathVariable Integer id) {
        return employeeRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeUpdated) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(employeeUpdated.getName());
        employee.setAge(employeeUpdated.getAge());
        employee.setDepartment(employeeUpdated.getDepartment());
        return employeeRepository.save(employee);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody void deleteEmployee(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
    }
}
