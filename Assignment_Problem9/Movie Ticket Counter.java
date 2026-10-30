import java.util.Scanner;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double calculateAmount();
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) { super(count); }
    @Override
    public double calculateAmount() {
        return (150.0 + CONVENIENCE_FEE) * count;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) { super(count); }
    @Override
    public double calculateAmount() {
        return (250.0 + CONVENIENCE_FEE) * count;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) { super(count); }
    @Override
    public double calculateAmount() {
        return (400.0 + CONVENIENCE_FEE) * count;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();
            Ticket ticket = null;

            switch (type.toUpperCase()) {
                case "REGULAR": ticket = new RegularTicket(count); break;
                case "PREMIUM": ticket = new PremiumTicket(count); break;
                case "RECLINER": ticket = new ReclinerTicket(count); break;
            }

            if (ticket != null) {
                double amount = ticket.calculateAmount();
                total += amount;
                System.out.printf("%s: %.2f\n", type.toUpperCase(), amount);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
