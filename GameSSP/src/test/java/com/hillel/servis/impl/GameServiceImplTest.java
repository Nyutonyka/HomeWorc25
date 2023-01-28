package com.hillel.servis.impl;

import com.hillel.dto.Computer;
import com.hillel.dto.Player;
import com.hillel.dto.Game;
import com.hillel.servis.GameService;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameServiceImplTest {

    @Test
    void startGame() {
        Player pl = new Player().setName(("pl_1"));
        Computer cm = new Computer();
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(pl, cm);

        assertNotNull(game);
        assertNotNull(game.getPlayer());
        assertNotNull(game.getComputer());
        assertNotNull(game.getChanOfSigns());
        assertEquals(3, game.getChanOfSigns().size());
    }

    @Test
    void playerHand() {
        Player pl = new Player().setName(("pl_1"));
        Computer cm = new Computer();
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(pl, cm);
        int i = gs.playerHand(game);

        assertNotNull(i);
        assertTrue(i >= 1 && i <= 3);
    }

    @Test
    void computerHand() {
        Computer cm = new Computer();
        Player pl = new Player();
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(pl, cm);
        int i = gs.computerHand(game);

        assertNotNull(i);
        assertTrue(i >= 1 && i <= 3);
    }

    @Test
    void showWinner() {
        Computer cm = new Computer();
        Player pl = new Player();
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(pl, cm);
        Locale defLocale = Locale.getDefault();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", defLocale);

        gs.showWinner(game, resourceBundle);
        assertEquals(1, game.getPlayer().getNumberOfGamesPlayed());
        gs.showWinner(game, resourceBundle);
        assertEquals(2, game.getPlayer().getNumberOfGamesPlayed());
    }
}