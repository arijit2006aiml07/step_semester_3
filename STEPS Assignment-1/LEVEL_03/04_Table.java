import java.util.Scanner;

class Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number: ");
            int num = sc.nextInt();

            if (num < 1) {
                System.out.println("Skipping invalid number: " + num);
                continue;
            }

            for (int j = 1; j <= 10; j++) {
                System.out.println(num + " x " + j + " = " + (num * j));
            }

            break;
        }
    }
}
