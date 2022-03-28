public class MainClass {
    public static void main(String[] args) {

        System.out.println("Start of the game");
        Logics logics = new Logics();
        String winner = logics.findTheWinner();
        System.err.println("Congratulations! "+winner+" wins!");
        System.out.println("End of the game");

    }

}
