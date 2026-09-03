import java.util.Scanner;

public class SignalStreak {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("No signal data provided.");
            return;
        }

        char maxColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }

            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + maxColor + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter signal log sequence (e.g. RRGGGYRR): ");
        String signalLog = scanner.nextLine();

        findLongestStreak(signalLog);
    }
}
