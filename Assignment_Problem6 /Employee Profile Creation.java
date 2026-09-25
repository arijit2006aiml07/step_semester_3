class EmployeeM3 {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeM3(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeM3(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " -| " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class MainM3 {
    public static void main(String[] args) {
        EmployeeM3 e1 = new EmployeeM3("E-101", "Divya", 65000);
        EmployeeM3 e2 = new EmployeeM3("E102", "Arjun");
        e1.printProfile();
        e2.printProfile();
    }
}
