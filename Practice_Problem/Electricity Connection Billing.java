import java.util.Scanner;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {
    Home(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100)
            return units * 5.0;
        else
            return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class Shop extends Connection {
    Shop(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8.0 + 100;
    }
}

class Factory extends Connection {
    Factory(int units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Connection[] connections = new Connection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("HOME"))
                connections[i] = new Home(units);
            else if (type.equals("SHOP"))
                connections[i] = new Shop(units);
            else if (type.equals("FACTORY"))
                connections[i] = new Factory(units);
        }

        for (int i = 0; i < n; i++) {
            double bill = connections[i].calculateBill();
            System.out.printf("%s: %.2f%n",
                connections[i] instanceof Home ? "HOME" :
                connections[i] instanceof Shop ? "SHOP" : "FACTORY",
                bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
