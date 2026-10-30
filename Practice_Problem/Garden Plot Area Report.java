import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            if (shape.equals("CIRCLE")) {
                double r = sc.nextDouble();
                plots[i] = new Circle(owner, r);
            }
            else if (shape.equals("RECTANGLE")) {
                double l = sc.nextDouble();
                double w = sc.nextDouble();
                plots[i] = new Rectangle(owner, l, w);
            }
            else if (shape.equals("TRIANGLE")) {
                double b = sc.nextDouble();
                double h = sc.nextDouble();
                plots[i] = new Triangle(owner, b, h);
            }
        }

        for (Plot p : plots) {
            double area = p.calculateArea();
            System.out.printf("%s (%s): %.2f%n",
                p.owner,
                p instanceof Circle ? "CIRCLE" :
                p instanceof Rectangle ? "RECTANGLE" : "TRIANGLE",
                area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
