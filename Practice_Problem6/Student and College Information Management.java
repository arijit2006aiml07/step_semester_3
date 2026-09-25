public class StudentDemo {
    public static void main(String[] args) {
        new Student("Alice", 90);
        new Student("Bob", 85);
        Student.printCollegeInfo();
    }
}

class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}
