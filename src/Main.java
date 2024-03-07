import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Select game" +
                "\n1. rock paper scissors" +
                "\n2. none" +
                "\n3. none" +
                "\nSelect:");
        int opt = in.nextInt();

        switch (opt) {
            case 1:
                RockPaperScissors game = new RockPaperScissors(RockPaperScissors.selectMode());
                game.play();
                break;

            default:
                System.out.println("Wrong value");
                break;
        }
    }
}