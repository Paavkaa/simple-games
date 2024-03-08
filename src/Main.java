import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Select game" +
                "\n1. Rock paper scissors" +
                "\n2. Number guesser" +
                "\n3. none" +
                "\nSelect:");
        int opt = in.nextInt();

        switch (opt) {
            case 1:
                RockPaperScissors game = new RockPaperScissors(RockPaperScissors.selectMode());
                game.play();
                break;
            case 2:
                NumberGuesser guesser = new NumberGuesser(0, 0, new int[0]);
                guesser.guessingRange();
                guesser.generateUnknown();
                System.out.println(guesser.unknownNum);
                break;
            default:
                System.out.println("Wrong value");
                break;
        }
    }
}