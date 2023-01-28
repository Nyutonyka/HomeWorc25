package com.hillel;
/*
 * @author Anna Babich
 * @version 1.0.1
 */
import java.util.Locale;
import java.util.ResourceBundle;
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
        Locale defLocale = Locale.getDefault();
        if (args.length != 0){
            defLocale = new Locale(args[0]);
        }

        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", defLocale);
        Scanner cs = new Scanner(System.in);
        logger.info(resourceBundle.getString("name"));
        String name = cs.nextLine();
        logger.info(resourceBundle.getString("numberOfGames"));
        int numberOfGames = cs.nextInt();
        cs.nextLine();

        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(new Player()
                .setName(name), new Computer());

        String nextGame = resourceBundle.getString("next");

        do {
            gs.playerHand(game);
            gs.computerHand(game);
            gs.showWinner(game, resourceBundle);
            if (--numberOfGames == 0) break;
            logger.info(resourceBundle.getString("nextGame"));
            nextGame = cs.nextLine();
        } while (nextGame.equalsIgnoreCase(resourceBundle.getString("next")));

        String resultPlay = gs.showResult(game, resourceBundle);
        logger.info(resultPlay);
        result.info(resultPlay);

        cs.close();
    }
}
