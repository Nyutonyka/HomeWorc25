package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Employee;
import org.example.model.LoyaltyBonus;
import org.example.repository.EmployeeRepository;
import org.example.repository.LoyaltyListRepository;
import org.example.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final EmployeeRepository employeeRepository;

    private final EmployeeService employeeService;

    private final LoyaltyListRepository loyaltyListRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Employee addNewEmployee(@RequestBody Employee employee) {
        LOG.info("Saving employee.");
        return employeeRepository.save(employee);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }


}
