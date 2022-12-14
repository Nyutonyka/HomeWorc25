package com.hillel;
/*
 * @author Anna Babich
 * @version 1.0.0
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
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

        System.out.println(gs.showResult(game));
        RecordingResults rr = new RecordingResults();

        OutputStream outputStream =
                new FileOutputStream(rr.fileNameGenerator(name));

        String str = gs.showResult(game);
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
        cs.close();
    }
}
