public class AttendanceSheet {
    private final String[] students;
    private int count;

    public AttendanceSheet(int capacity) {
        this.students = new String[capacity];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }
        if (this.count < this.students.length) {
            this.students[this.count] = name;
            this.count++;
        }
    }

    public int getPresentCount() {
        return this.count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < this.count; i++) {
            if (this.students[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}
