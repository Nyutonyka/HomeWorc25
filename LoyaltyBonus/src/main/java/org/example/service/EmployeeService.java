package org.example.service;


import org.example.model.Employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

}
