import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

abstract class Subscriber {
    protected String name;
    protected LocalDate startDate;
    public Subscriber(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    public abstract LocalDate calculateRenewalDate();
    public String getName() { return name; }
}

class BasicSubscriber extends Subscriber {
    public BasicSubscriber(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(30); }
}

class StandardSubscriber extends Subscriber {
    public StandardSubscriber(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(90); }
}

class PremiumSubscriber extends Subscriber {
    public PremiumSubscriber(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(365); }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);
            if (type.equals("BASIC")) {
                subscribers.add(new BasicSubscriber(name, startDate));
            } else if (type.equals("STANDARD")) {
                subscribers.add(new StandardSubscriber(name, startDate));
            } else if (type.equals("PREMIUM")) {
                subscribers.add(new PremiumSubscriber(name, startDate));
            }
        }
        for (Subscriber s : subscribers) {
            LocalDate renewalDate = s.calculateRenewalDate();
            System.out.println(s.getName() + ": " + renewalDate);
        }
    }
}
