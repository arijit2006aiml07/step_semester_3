class EmployeeM5 {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeM5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class MainM5 {
    public static void main(String[] args) {
        EmployeeM5 e1 = new EmployeeM5("Alice", 50000);
        EmployeeM5 e2 = new EmployeeM5("Bob", 60000);
        EmployeeM5 e3 = new EmployeeM5("Charlie", 55000);
        
        System.out.println("3 Employee objects created");
        EmployeeM5.printCompanyInfo();
    }
}
