import java.lang.String;

public class Problem3 {

    public String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String ext = filename.substring(dotIndex + 1);

        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        Problem3 p = new Problem3();
        System.out.println(p.validateFileExtension("Assignment1.PDF"));
        System.out.println(p.validateFileExtension("notes.txt"));
    }
}
