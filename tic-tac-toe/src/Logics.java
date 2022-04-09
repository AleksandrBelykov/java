import utils.Constants;
import utils.Player;
import utils.Utils;

import java.util.Scanner;

public class Logics {
    private static char[] grid = Utils.initGrid;
    private String winner = "";
    private int turnsCounter = 0;

    String findTheWinner(Scanner scanner){

        System.out.println("Player1, enter your name, please:");
        String Player1Name = scanner.nextLine();
        System.out.println("Player2, enter your name, please:");
        String Player2Name = scanner.nextLine();

        Player player1 = new Player(Constants.X, Player1Name);
        Player player2 = new Player(Constants.ZERO, Player2Name);

        System.out.println("Show initial grid: ");
        Utils.showGrid(grid);

        while (true) {
            ++turnsCounter;
            winner = takeTurn(scanner, turnsCounter, player1);
            if (!winner.isEmpty() || turnsCounter == 9) {
                break;
            }

            ++turnsCounter;
            winner = takeTurn(scanner, turnsCounter, player2);
            if (!winner.isEmpty() || turnsCounter == 9) {
                break;
            }
        }

        return winner;
    }

    private static String takeTurn(Scanner scanner, int turnsCounter, Player player){
        int position;
        boolean winFlag;

        System.err.printf(player.getName()+", your turn:%n");
        position = Utils.readPositionFromConsole(scanner);
        Utils.substitutePosition(grid, player, position);
        System.out.println("turnsCounter is " + turnsCounter);

        if (turnsCounter > 4) {
            winFlag = Utils.checkForWins(grid, player);
            System.out.println("winFlag is " + winFlag);

            if (winFlag) {
                Utils.showGrid(grid);
                return player.getName();
            }
        }

        System.out.println("continue the game");
        Utils.showGrid(grid);
        return "";
    }


}
