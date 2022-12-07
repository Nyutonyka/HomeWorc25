package com.hillel.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Player {
    private Signs name;
    private Integer numberOfGames;
    private Integer numberOfWinGames;
    private Integer numberOfWins;
    private Integer numberOfLosses;
    private String hand;

    @Override
    public String toString() {
        return "Player" + name +
                " : " +
                " number of win games - " + numberOfWinGames +
                ", \nWins - " + numberOfWins +
                ", \nLosses - " + numberOfLosses;
    }
}
