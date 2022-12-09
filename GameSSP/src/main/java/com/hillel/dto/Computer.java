package com.hillel.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Computer {
    private Signs signs;
}
