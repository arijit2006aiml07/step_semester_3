import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"Rock", "Paper", "Scissors"};
        
        int wins = 0, losses = 0, draws = 0, totalRounds = 5;

        for (int i = 1; i <= totalRounds; i++) {
            System.out.print("Round " + i + " - Enter move (Rock, Paper, Scissors): ");
            String playerMove = scanner.next();
            String computerMove = options[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);
            System.out.println("Computer: " + computerMove + " | Result: " + result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.println("\nFinal Summary:");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }
}
