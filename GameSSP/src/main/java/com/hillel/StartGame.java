package com.hillel;
/*
 * @author Anna Babich
 * @version 1.0.0
 */
import java.io.*;
import java.util.Scanner;

import com.hillel.dto.*;
import com.hillel.servis.impl.RecordingResults;
import com.hillel.servis.GameService;
import com.hillel.servis.impl.GameServiceImpl;

public class StartGame {

    public static void main(String[] args) throws IOException {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter your name ...");
        String name = cs.nextLine();
        System.out.println("Enter number of games ...");
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
            System.out.println("Next game ... [Y/N]");
            nextGame = cs.nextLine();
        } while (nextGame.equalsIgnoreCase("y"));

        String result = gs.showResult(game);
        System.out.println(result);

        RecordingResults rr = new RecordingResults();
        File file= new File(rr.fileNameGenerator(name));
        rr.appendToFile(file, result);

        cs.close();
    }
}
