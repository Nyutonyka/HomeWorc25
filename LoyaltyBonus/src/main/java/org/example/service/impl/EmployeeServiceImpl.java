package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements org.example.service.EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll().stream().toList();
    }
}
