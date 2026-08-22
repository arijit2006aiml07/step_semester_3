import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Not a Prime number");
        } else {
            int i;
            for (i = 2; i < n; i++) {
                if (n % i == 0) {
                    break;
                }
            }

            if (i == n)
                System.out.println("Prime number");
            else
                System.out.println("Not a Prime number");
        }
    }
}