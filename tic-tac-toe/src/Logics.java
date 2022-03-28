import utils.Constants;
import utils.Player;
import utils.Utils;

import java.util.Scanner;

public class Logics {
    private static char[] grid = Utils.initGrid;
    public String winner;

    String findTheWinner(){
        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player(Constants.X);
        Player player2 = new Player(Constants.ZERO);

        System.out.println("Show initial grid: ");
        Utils.showGrid(grid);

        int position;
        int turnsCounter = 0;


        while (true) {
            boolean winFlag;

            System.out.println("Player1, your turn:");
            position = Utils.readPositionFromConsole(scanner);
            Utils.substitutePosition(grid, player1, position);
            Utils.showGrid(grid);
            ++turnsCounter;
            System.out.println("turnsCounter is " + turnsCounter);

            if (turnsCounter > 4) {
                winFlag = Utils.checkForWins(grid, player1);
                System.out.println("winFlag is " + winFlag);

                if (winFlag == true) {
                    winner = "Player 1";
                    break;
                } else {
                    System.out.println("continue the game");
                }
            }

            System.out.println("Player2, your turn:");
            position = Utils.readPositionFromConsole(scanner);
            Utils.substitutePosition(grid, player2, position);
            Utils.showGrid(grid);
            ++turnsCounter;
            System.out.println("turnsCounter is " + turnsCounter);

            if (turnsCounter > 5) {
                winFlag = Utils.checkForWins(grid, player2);
                System.out.println("winFlag is " + winFlag);

                if (winFlag == true) {
                    winner = "Player 2";
                    break;
                } else {
                    System.out.println("continue the game");
                }
            }
        }

        scanner.close();
        return winner;
    }
}
