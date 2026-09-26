import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

interface LibraryItem {
    LocalDate getDueDate();
    String getTitle();
}

class BookItem implements LibraryItem {
    private String title;
    public BookItem(String title) {
        this.title = title;
    }
    public LocalDate getDueDate() {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        return currentDate.plusDays(14);
    }
    public String getTitle() {
        return title;
    }
}

class DVDItem implements LibraryItem {
    private String title;
    public DVDItem(String title) {
        this.title = title;
    }
    public LocalDate getDueDate() {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        return currentDate.plusDays(7);
    }
    public String getTitle() {
        return title;
    }
}

class MagazineItem implements LibraryItem {
    private String title;
    public MagazineItem(String title) {
        this.title = title;
    }
    public LocalDate getDueDate() {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        return currentDate.plusDays(3);
    }
    public String getTitle() {
        return title;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "").trim();
            if (type.equals("BOOK")) {
                items.add(new BookItem(title));
            } else if (type.equals("DVD")) {
                items.add(new DVDItem(title));
            } else if (type.equals("MAGAZINE")) {
                items.add(new MagazineItem(title));
            }
        }
        scanner.close();

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.getDueDate());
        }
    }
}
