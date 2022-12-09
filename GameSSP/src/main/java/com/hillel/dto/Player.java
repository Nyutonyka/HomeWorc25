package com.hillel.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Player {
    private String name;
    private Integer numberOfGamesPlayed = 0;
    private Integer numberOfDraw = 0;
    private Integer numberOfWins = 0;
    private Integer numberOfLosses = 0;
    private Signs signs;
}
