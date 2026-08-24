import java.util.Scanner;

class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correct = "1234";
        boolean access = false;

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter code: ");
            String code = sc.next();

            if (code.equals(correct)) {
                System.out.println("Access granted on attempt " + i);
                access = true;
                break;
            }
        }

        if (!access)
            System.out.println("Access denied — all attempts used");
    }
}
