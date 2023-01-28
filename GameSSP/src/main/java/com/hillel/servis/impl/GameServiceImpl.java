package com.hillel.servis.impl;

import com.hillel.dto.*;
import com.hillel.servis.GameService;
import com.hillel.servis.HandSigns;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

public class GameServiceImpl implements GameService {

    private static final Logger play = LoggerFactory.getLogger("play");

    private static final HandSigns hs = new HandSignsImpl();

    @Override
    public Game startGame(Player player, Computer computer) {
        return new Game()
                .setPlayer(player)
                .setComputer(computer)
                .setChanOfSigns(new HandSignsImpl().chainOfSigns());
    }

    @Override
    public int playerHand(Game game) {
        Signs signs = hs.getHandSigns(game.getChanOfSigns());
        game.getPlayer().setSigns(signs);
        return game.getPlayer().getSigns().getIndex();
    }

    @Override
    public int computerHand(Game game) {
        Signs signs = hs.getHandSigns(game.getChanOfSigns());
        game.getComputer().setSigns(signs);
        return game.getComputer().getSigns().getIndex();
    }

    @Override
    public void showWinner(Game game, ResourceBundle resourceBundle) {
        int plIndex = playerHand(game);
        int cmIndex = computerHand(game);
        Signs plHand = game.getPlayer().getSigns();
        Signs cmHand = game.getComputer().getSigns();

        play.info(resourceBundle.getString("player") + ": " + plHand);
        play.info(resourceBundle.getString("computer") + ": " + cmHand);

        if (plIndex == 1 && cmIndex == 2) {
            play.info(resourceBundle.getString("player"));
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfWins(game.getPlayer().getNumberOfWins() + 1);
        } else if (plIndex == 1 && cmIndex == 3) {
            play.info(resourceBundle.getString("computer"));
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfLosses(game.getPlayer().getNumberOfLosses() + 1);
        } else if (plIndex == 2 && cmIndex == 1) {
            play.info(resourceBundle.getString("computer"));
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfLosses(game.getPlayer().getNumberOfLosses() + 1);
        } else if (plIndex == 2 && cmIndex == 3) {
            play.info(resourceBundle.getString("player"));
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfWins(game.getPlayer().getNumberOfWins() + 1);
        } else if (plIndex == 3 && cmIndex == 1) {
            play.info(resourceBundle.getString("player"));
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfWins(game.getPlayer().getNumberOfWins() + 1);
        } else if (plIndex == 3 && cmIndex == 2) {
            play.info(resourceBundle.getString("computer"));
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfLosses(game.getPlayer().getNumberOfLosses() + 1);
        } else if (plIndex == cmIndex) {
            play.info(resourceBundle.getString("draw"));
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfDraw(game.getPlayer().getNumberOfDraw() + 1);
        }
    }

    @Override
    public String showResult(Game game, ResourceBundle resourceBundle) {
        String showText = resourceBundle.getString("showResult");
        return String.format(showText,
                game.getPlayer().getName(),
                game.getPlayer().getNumberOfGamesPlayed(),
                game.getPlayer().getNumberOfWins(),
                game.getPlayer().getNumberOfLosses(),
                game.getPlayer().getNumberOfDraw());
    }
}
