import java.util.HashMap;
import java.util.Scanner;

public class RockPaperScissors {
    public enum Options {
        ROCK,
        PAPER,
        SCISSORS
    }

    public enum gameMode {
        WINS,
        ROUNDS
    }

    Options playerOpt;
    gameMode mode;

    public RockPaperScissors(gameMode mode) {
        this.playerOpt = null;
        this.mode = mode;
    }

    private static Options selectOpt() {
        Scanner in = new Scanner(System.in);
        System.out.println("Select option:\n" +
                "1. Rock\n" +
                "2. Paper\n" +
                "3. Scissors\n" +
                "Select:");
        String opt = in.nextLine().toLowerCase();

        return switch (opt) {
            case "1", "rock" -> Options.ROCK;
            case "2", "paper" -> Options.PAPER;
            case "3", "scissors" -> Options.SCISSORS;
            default -> throw new IllegalArgumentException("Unexpected value: " + opt);
        };
    }

    public static gameMode selectMode() {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Select mode:
                1. Wins
                2. Rounds
                Select:
                """);
        String opt = in.nextLine().toLowerCase();

        return switch (opt) {
            case "1", "wins" -> gameMode.WINS;
            case "2", "rounds" -> gameMode.ROUNDS;
            default -> throw new IllegalArgumentException("Unexpected value: " + opt);
        };

    }

    public void play() {
        if (mode != gameMode.WINS && mode != gameMode.ROUNDS) {
            throw new IllegalArgumentException("Invalid mode");
        }

        Scanner in = new Scanner(System.in);
        int playerWins = 0;
        Options playerOpt;
        int compWins = 0;
        Options compOpt;

        String inputMessage = (mode == gameMode.WINS) ? "Enter number of wins:" : "Enter number of rounds:";
        System.out.println(inputMessage);
        int rounds = in.nextInt();

        for (int i = 0; i < rounds; i++) {
            playerOpt = selectOpt();
            compOpt = Options.values()[(int) (Math.random() * 3)];
            System.out.println("Computer: " + compOpt);

            GameResult result = determineWinner(playerOpt, compOpt);

            if (result == GameResult.WIN) {
                playerWins++;
            } else if (result == GameResult.LOSS) {
                compWins++;
            }

            System.out.println("Player: " + playerWins + " Computer: " + compWins);

            if (mode == gameMode.WINS && (playerWins >= rounds || compWins >= rounds)) {
                break;
            } else if (mode == gameMode.ROUNDS && i == rounds - 1) {
                break;
            } else {
                System.out.println("Next round");
            }
        }
    }

    private enum GameResult {
        WIN,
        LOSS,
        DRAW
    }

    private static GameResult determineWinner(Options playerOpt, Options compOpt) {
        if (playerOpt == compOpt) {
            System.out.println("Tie");
            return GameResult.DRAW;
        } else if ((playerOpt == Options.ROCK && compOpt == Options.SCISSORS) ||
                (playerOpt == Options.PAPER && compOpt == Options.ROCK) ||
                (playerOpt == Options.SCISSORS && compOpt == Options.PAPER)) {
            System.out.println("You win");
            return GameResult.WIN;
        } else {
            System.out.println("Computer wins");
            return GameResult.LOSS;
        }
    }



}