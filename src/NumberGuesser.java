import java.util.Scanner;
import java.util.TreeSet;

public class NumberGuesser {
    private int minNum;
    private int maxNum;
    public int rounds;
    private TreeSet<Integer> guessedNum = new TreeSet<>();

    public NumberGuesser(int rounds) {
        this.rounds = rounds;
    }

    public void guessingRange() {
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Enter the range of numbers to guess:" +
                    "\nMin:");
            minNum = in.nextInt();
            System.out.println("Max:");
            maxNum = in.nextInt();
        } while (minNum > maxNum);
    }

    public static int numOfRounds() {
        int rounds;
        do {
            System.out.println("Enter the number of rounds:");
            rounds = new Scanner(System.in).nextInt();
        } while (rounds < 1);
        return rounds;
    }

    private int generateNum() {
        guessingRange();
        return (int) (Math.random() * (maxNum - minNum + 1) + minNum);
    }

    public void guess() {
        int unknownNum = generateNum();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Enter your guess:");
            guessedNum.add(in.nextInt());

            if (guessedNum.contains(unknownNum)) {
                System.out.println("You guessed the correct number!");
                break;
            } else if (guessedNum.last() < unknownNum) {
                System.out.println("The number is greater than your guess");
            } else {
                System.out.println("The number is less than your guess");
            }

            System.out.println("Guessed numbers: " + guessedNum);

        } while (rounds-- > 1);

        guessedNum = new TreeSet<>();
    }
}
