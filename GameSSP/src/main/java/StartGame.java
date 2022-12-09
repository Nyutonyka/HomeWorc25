import java.util.Scanner;

import com.hillel.dto.*;
import com.hillel.servis.GameService;
import com.hillel.servis.impl.GameServiceImpl;

public class StartGame {

    public static void main(String[] args) {
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
    }
}