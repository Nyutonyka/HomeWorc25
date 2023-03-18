package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Employee;

@Getter
@Setter
public class EmployeeDto {
    private String name;
    private int experience;

    @Override
    public String toString() {
        return name + '.' + experience;
    }

}
