import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Start of the game");

        Scanner scanner = new Scanner(System.in);

        Logics logics = new Logics();
        String winner = logics.findTheWinner(scanner);
        if (winner.isEmpty()){
            System.out.printf("Game over!%nThere is no any winner.%n");
        } else{
            System.err.println("Congratulations! "+winner+" wins!");
        }

        scanner.close();

        System.out.println("End of the game");

    }

}
