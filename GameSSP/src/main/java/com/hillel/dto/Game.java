package com.hillel.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Game {
    private Player player;
    private Computer computer;
    private Signs signs;
}
