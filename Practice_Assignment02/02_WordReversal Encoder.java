public class WordReverser {
    
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversedWord = "";

            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord += word.charAt(j);
            }

            result += reversedWord;
            if (i < words.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "hello world";
        String output = reverseEachWord(input);
        
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
