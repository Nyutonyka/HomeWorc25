package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.LoyaltyBonus;
import org.example.repository.LoyaltyListRepository;
import org.example.service.LoyaltyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/loyalty_bonus")
@RequiredArgsConstructor
public class LoyaltyController {

    private final LoyaltyService loyaltyService;

    @RequestMapping(value = "/loyalty", method = RequestMethod.POST)
    public void addEmployeesLoyalty(int experience){
        loyaltyService.addEmployeesLoyalty(experience);
    }

    @RequestMapping(value = "/loyalty_employees", method = RequestMethod.GET)
    public List<LoyaltyBonus> getAllEmployeeLoyalty(){
        return loyaltyService.getEmployeesLoyalty();
    }
}
