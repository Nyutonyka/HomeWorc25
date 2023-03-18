package org.example.service;

import org.example.model.LoyaltyBonus;

import java.util.List;

public interface LoyaltyService {

    void addEmployeesLoyalty(int experience);

    List<LoyaltyBonus> getEmployeesLoyalty();
}
