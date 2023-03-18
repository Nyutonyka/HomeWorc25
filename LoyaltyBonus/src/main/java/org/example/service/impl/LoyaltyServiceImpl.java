package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Employee;
import org.example.model.LoyaltyBonus;
import org.example.repository.EmployeeRepository;
import org.example.repository.LoyaltyListRepository;
import org.example.service.LoyaltyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoyaltyServiceImpl implements LoyaltyService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final LoyaltyListRepository loyaltyListRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void addEmployeesLoyalty(int experience){
        List<Employee> employeeList = employeeRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getExperience))
                .toList();
        List<Employee> loyaltyBonusEmployee = new ArrayList<>();
        for (Employee e : employeeList) {
            int ex = e.getExperience();
            if(ex >= experience){
                loyaltyBonusEmployee.add(e);
                String name = e.getName();
                LoyaltyBonus loyaltyBonus = new LoyaltyBonus();
                loyaltyBonus.setEmployees(name);
                loyaltyListRepository.save(loyaltyBonus);
            }
        }
        if(loyaltyBonusEmployee.isEmpty()){
            LOG.info("There are no employees matching the request.");
        }
    }

    @Override
    public List<LoyaltyBonus> getEmployeesLoyalty() {
        return loyaltyListRepository.findAll().stream().toList();
    }
}
