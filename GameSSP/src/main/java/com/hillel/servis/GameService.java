package com.hillel.servis;

import com.hillel.dto.Computer;
import com.hillel.dto.Game;
import com.hillel.dto.Player;

public interface GameService {
    Game startGame(Player player, Computer computer);

    int playerHand(Game game);

    int computerHand(Game game);

    void showWinner(Game game);

    String showResult(Game game);
}
