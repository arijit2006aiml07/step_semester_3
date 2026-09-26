import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

interface Payment {
    double calculateFinalAmount();
    String getType();
}

class CardPayment implements Payment {
    private double amount;
    public CardPayment(double amount) {
        this.amount = amount;
    }
    public double calculateFinalAmount() {
        return amount * 1.02;
    }
    public String getType() {
        return "CARD";
    }
}

class WalletPayment implements Payment {
    private double amount;
    public WalletPayment(double amount) {
        this.amount = amount;
    }
    public double calculateFinalAmount() {
        return amount * 1.01;
    }
    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment implements Payment {
    private double amount;
    public BankTransferPayment(double amount) {
        this.amount = amount;
    }
    public double calculateFinalAmount() {
        return amount;
    }
    public String getType() {
        return "BANKTRANSFER";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if (type.equals("CARD")) {
                payments.add(new CardPayment(amount));
            } else if (type.equals("WALLET")) {
                payments.add(new WalletPayment(amount));
            } else if (type.equals("BANKTRANSFER")) {
                payments.add(new BankTransferPayment(amount));
            }
        }
        scanner.close();

        double grandTotal = 0;
        for (Payment p : payments) {
            double finalAmount = p.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", p.getType(), finalAmount);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}
