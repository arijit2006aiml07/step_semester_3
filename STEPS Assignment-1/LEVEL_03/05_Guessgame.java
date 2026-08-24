import java.util.Scanner;

class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int secret = 42;
        int maxTries = 4;
        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && !guessed) {

            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();

            tries++;

            if (guess > secret)
                System.out.println("Too high");

            else if (guess < secret)
                System.out.println("Too low");

            else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }
        }

        if (!guessed)
            System.out.println("Out of tries — the number was " + secret);
    }
}
