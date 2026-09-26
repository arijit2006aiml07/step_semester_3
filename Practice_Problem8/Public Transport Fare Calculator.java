import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

interface Journey {
    double calculateFare();
    String getType();
}

class BusJourney implements Journey {
    private double distance;
    public BusJourney(double distance) {
        this.distance = distance;
    }
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
    public String getType() {
        return "BUS";
    }
}

class TrainJourney implements Journey {
    private double distance;
    public TrainJourney(double distance) {
        this.distance = distance;
    }
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
    public String getType() {
        return "TRAIN";
    }
}

class MetroJourney implements Journey {
    private double distance;
    private double peakHourFactor;
    public MetroJourney(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
    public String getType() {
        return "METRO";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            if (type.equals("BUS")) {
                journeys.add(new BusJourney(distance));
            } else if (type.equals("TRAIN")) {
                journeys.add(new TrainJourney(distance));
            } else if (type.equals("METRO")) {
                double factor = scanner.nextDouble();
                journeys.add(new MetroJourney(distance, factor));
            }
        }
        scanner.close();

        double total = 0;
        for (Journey j : journeys) {
            double fare = j.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f\n", j.getType(), fare);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
