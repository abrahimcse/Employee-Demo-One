package com.task.Employee.Demo.controller;

import com.task.Employee.Demo.entity.Employee;
import com.task.Employee.Demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/addList")
    public List<Employee> addAllEmployee(@RequestBody List<Employee> employees) {
        return employeeService.saveAllEmployee(employees);
    }

    @GetMapping("/list")
    public List<Employee> findAllEmployee() {
        return  employeeService.getEmployee();
    }

    @GetMapping
    public List<Employee> searchEmployee(@RequestParam(value = "name", required = false) String name,
                                             @RequestParam(value = "designation", required = false) String designation,
                                             @RequestParam(value = "gender", required = false) String gender,
                                             @RequestParam(value = "age", required = false) int [] ages) {
      return employeeService.getEmployeeList(name, designation, gender,ages);

    }





    // TODO: Search Employee
    /*
     * method: searchEmployee(params)
     * by name - input: partial name words
     * by designation - input: designation as string
     * by gender - input: gender as string
     * by range of age (10-15)- input: age array [10, 15]
     *
     */


}
