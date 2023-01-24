package com.hillel;
/*
 * @author Anna Babich
 * @version 1.0.1
 */
import java.util.Scanner;

import com.hillel.dto.*;
import com.hillel.servis.GameService;
import com.hillel.servis.impl.GameServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartGame {

    private static final Logger result = LoggerFactory.getLogger("result");
    private static final Logger logger = LoggerFactory.getLogger("stdout");

    public static void main(String[] args)  {
        Scanner cs = new Scanner(System.in);
        logger.info("Enter your name ...");
        String name = cs.nextLine();
        logger.info("Enter number of games ...");
        int numberOfGames = cs.nextInt();
        cs.nextLine();

        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(new Player()
                .setName(name), new Computer());

        String nextGame = "Y";

        do {
            gs.playerHand(game);
            gs.computerHand(game);
            gs.showWinner(game);
            if (--numberOfGames == 0) break;
            logger.info("Next game ... [Y/N]");
            nextGame = cs.nextLine();
        } while (nextGame.equalsIgnoreCase("y"));

        String resultPlay = gs.showResult(game);
        logger.info(resultPlay);
        result.info(resultPlay);

        cs.close();
    }
}
