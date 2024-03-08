import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Select game" +
                "\n1. Rock paper scissors" +
                "\n2. Number guessing" +
                "\n3. none" +
                "\nSelect:");
        int opt = in.nextInt();

        switch (opt) {
            case 1:
                RockPaperScissors game = new RockPaperScissors(RockPaperScissors.selectMode());
                game.play();
                break;
            case 2:
                int rounds = NumberGuesser.numOfRounds();
                NumberGuesser guesser = new NumberGuesser(rounds);
                guesser.guess();
                break;

            default:
                System.out.println("Wrong value");
                break;
        }
    }
}