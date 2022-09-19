package com.company.springcrud;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(path="/add")
    public @ResponseBody void addNewEmployee(@RequestParam String name, @RequestParam Integer age, @RequestParam String department) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/find/{id}")
    public @ResponseBody Optional<Employee> getEmployeeById(@PathVariable Integer id) {
        return employeeRepository.findById(id);
    }

    @PutMapping(path = "/update")
    public @ResponseBody void updateEmployee(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age, @RequestParam String department) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAge(age);
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody void deleteEmployee(@RequestParam Integer id) {
        employeeRepository.deleteById(id);
    }
}

