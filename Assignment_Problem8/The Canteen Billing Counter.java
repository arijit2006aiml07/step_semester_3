import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Customer {
    protected double amount;
    public Customer(double amount) {
        this.amount = amount;
    }
    public abstract double calculateFinalAmount();
    public abstract String getTypeName();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 0.9; }
    @Override
    public String getTypeName() { return "STUDENT"; }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 0.95; }
    @Override
    public String getTypeName() { return "STAFF"; }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount + 10.0; }
    @Override
    public String getTypeName() { return "GUEST"; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amt = scanner.nextDouble();
            if (type.equals("STUDENT")) {
                customers.add(new StudentCustomer(amt));
            } else if (type.equals("STAFF")) {
                customers.add(new StaffCustomer(amt));
            } else if (type.equals("GUEST")) {
                customers.add(new GuestCustomer(amt));
            }
        }
        double total = 0;
        for (Customer c : customers) {
            double finalAmt = c.calculateFinalAmount();
            total += finalAmt;
            System.out.printf("%s: %.2f\n", c.getTypeName(), finalAmt);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
