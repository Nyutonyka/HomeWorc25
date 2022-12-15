package com.hillel.servis.impl;

import com.hillel.dto.*;
import com.hillel.servis.GameService;
import com.hillel.servis.HandSigns;

public class GameServiceImpl implements GameService {

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
    public void showWinner(Game game) {
        int plIndex = playerHand(game);
        int cmIndex = computerHand(game);
        Signs plHand = game.getPlayer().getSigns();
        Signs cmHand = game.getComputer().getSigns();

        System.out.println("Player: " + plHand);
        System.out.println("Computer: " + cmHand);

        if (plIndex == 1 && cmIndex == 2) {
            System.out.println("Player");
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfWins(game.getPlayer().getNumberOfWins() + 1);
        } else if (plIndex == 1 && cmIndex == 3) {
            System.out.println("Computer");
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfLosses(game.getPlayer().getNumberOfLosses() + 1);
        } else if (plIndex == 2 && cmIndex == 1) {
            System.out.println("Computer");
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfLosses(game.getPlayer().getNumberOfLosses() + 1);
        } else if (plIndex == 2 && cmIndex == 3) {
            System.out.println("Player");
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfWins(game.getPlayer().getNumberOfWins() + 1);
        } else if (plIndex == 3 && cmIndex == 1) {
            System.out.println("Player");
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfWins(game.getPlayer().getNumberOfWins() + 1);
        } else if (plIndex == 3 && cmIndex == 2) {
            System.out.println("Computer");
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfLosses(game.getPlayer().getNumberOfLosses() + 1);
        } else if (plIndex == cmIndex) {
            System.out.println("Draw");
            game.getPlayer().setNumberOfGamesPlayed(game.getPlayer().getNumberOfGamesPlayed() + 1);
            game.getPlayer().setNumberOfDraw(game.getPlayer().getNumberOfDraw() + 1);
        }
    }

    @Override
    public String showResult(Game game) {
        return String.format("Player : %s. Total games %s: win - %s lost - %s draw - %s\n",
                game.getPlayer().getName(),
                game.getPlayer().getNumberOfGamesPlayed(),
                game.getPlayer().getNumberOfWins(),
                game.getPlayer().getNumberOfLosses(),
                game.getPlayer().getNumberOfDraw());
    }
}
