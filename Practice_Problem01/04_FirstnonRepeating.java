public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (text.indexOf(ch) == text.lastIndexOf(ch)) {
                return ch;
            }
        }
        return '\0'; 
    }

    public static void main(String[] args) {
        String text = "swiss";
        char result = findFirstNonRepeatingChar(text);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }
}
