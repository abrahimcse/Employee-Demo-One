package com.task.Employee.Demo.service;

import com.task.Employee.Demo.entity.Employee;
import com.task.Employee.Demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> saveAllEmployee(List<Employee> employee) {
        return repository.saveAll(employee);
    }

    public List<Employee> getEmployee() {
        return repository.findAll();
    }

    public List<Employee> getEmployeeList(String name, String designation, String gender, int[] age) {
        List<Employee> employees = repository.findAll();

        return employees.stream()
                .filter(e -> (name == null || e.getName().toLowerCase().contains(name.toLowerCase()))
                        && (designation == null || e.getDesignation().toLowerCase().contains(designation.toLowerCase()))
                        && (gender == null || e.getGender().toLowerCase().contains(gender.toLowerCase()))
                        && (age == null || (e.getAge() >= age[0] && e.getAge() <= age[1])))
                .collect(Collectors.toList());
    }

    }
