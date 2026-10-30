import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;
    public Student(String name) { this.name = name; }
    public abstract double calculateFee();
    public String getName() { return name; }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) { super(name); }
    @Override
    public double calculateFee() { return 40000.0 + getTransportFee(); }
    @Override
    public double getTransportFee() { return 12000.0; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    @Override
    public double calculateFee() { return 40000.0 + 60000.0; }
}

class ScholarshipStudent extends Student implements BusUser {
    public ScholarshipStudent(String name) { super(name); }
    @Override
    public double calculateFee() { return 20000.0 + getTransportFee(); }
    @Override
    public double getTransportFee() { return 12000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String type = "";
            String name = "";

            if (line.startsWith("DAY SCHOLAR")) {
                type = "DAY_SCHOLAR";
                name = line.substring("DAY SCHOLAR".length()).trim();
            } else if (line.startsWith("HOSTELLER")) {
                type = "HOSTELLER";
                name = line.substring("HOSTELLER".length()).trim();
            } else if (line.startsWith("SCHOLAR")) {
                type = "SCHOLAR";
                name = line.substring("SCHOLAR".length()).trim();
            }

            Student student = null;
            switch (type) {
                case "DAY_SCHOLAR": student = new DayScholar(name); break;
                case "HOSTELLER": student = new Hosteller(name); break;
                case "SCHOLAR": student = new ScholarshipStudent(name); break;
            }

            if (student != null) {
                double fee = student.calculateFee();
                totalCollected += fee;
                System.out.printf("%s: %.2f\n", student.getName(), fee);
            }
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}
