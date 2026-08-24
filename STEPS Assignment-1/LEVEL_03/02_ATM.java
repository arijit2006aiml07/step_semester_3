import java.util.Scanner;

class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctPin = "4821";
        int attempts = 0;
        boolean success = false;

        while (attempts < 3 && !success) {
            System.out.print("Enter PIN: ");
            String pin = sc.next();

            attempts++;

            if (pin.equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
        }

        if (!success)
            System.out.println("Card blocked — too many incorrect attempts");
    }
}
