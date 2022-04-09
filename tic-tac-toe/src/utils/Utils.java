package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {
    public static char[] initGrid = new char[]{
            '1','2','3',
            '4','5','6',
            '7','8','9'
    };

    public static void showGrid(char[] grid){
        int counter = 0;
        for(char i : grid){
            System.out.print((Character)i);
            ++counter;
            if(counter == 3){
                System.out.print("\n");
                counter = 0;
            } else System.out.print(" ");
        }
    }

    public static int readPositionFromConsole(Scanner scanner){
        int position;
        while(true) {
            System.out.println("Enter the position from 1 to 9:");
            String posObj = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\d+?");

            if (posObj != null){
                if (pattern.matcher(posObj).matches()) {
                    if (Integer.parseInt(posObj) > 0 && Integer.parseInt(posObj) < 10) {
                        position = Integer.parseInt(posObj);
                           System.out.println("pos = "+position);
                        break;
                    }
                }
            }
            System.out.println("Invalid num of position, try again");
        }

        return position;
    }

    public static char[] substitutePosition(char[] grid, Player player, int position){
        char[] resultGrid = grid;
        resultGrid[position-1] = player.getMarker();
        return resultGrid;
    }

    public static boolean checkForWins(char[] grid, Player player){
        int threePositionsToWin = 0;
        boolean result = false;

        for(int[] row : Constants.winCombinations){

            for(int i : row){
                if(grid[i] == player.getMarker()){
                    ++threePositionsToWin;
                    System.out.println("threePositionsToWin is "+threePositionsToWin);
                }
            }

            if (threePositionsToWin==3){
                result = true;
                break;
            }
            threePositionsToWin = 0;
        }
        return result;
    }
}
