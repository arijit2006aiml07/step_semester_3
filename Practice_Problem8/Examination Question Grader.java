import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Question {
    double grade();
    String getType();
}

class MCQQuestion implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private int points;

    public MCQQuestion(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TFQuestion implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private int points;

    public TFQuestion(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    public String getType() {
        return "TF";
    }
}

class EssayQuestion implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private int points;

    public EssayQuestion(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudent = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && lowerStudent.contains(trimmedKw)) {
                matchCount++;
            }
        }
        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Question> questions = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|([^\\s]+)");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            List<String> tokens = new ArrayList<>();
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    tokens.add(matcher.group(1));
                } else {
                    tokens.add(matcher.group(2));
                }
            }

            if (tokens.size() >= 4) {
                String type = tokens.get(0);
                String qText = tokens.get(1);
                String cAns = tokens.get(2);
                String sAns = tokens.get(3);
                int pts = tokens.size() > 4 ? Integer.parseInt(tokens.get(4)) : 0;

                if (type.equals("MCQ")) {
                    questions.add(new MCQQuestion(cAns, sAns, pts));
                } else if (type.equals("TF")) {
                    questions.add(new TFQuestion(cAns, sAns, pts));
                } else if (type.equals("ESSAY")) {
                    questions.add(new EssayQuestion(cAns, sAns, pts));
                }
            }
        }
        scanner.close();

        double totalScore = 0;
        for (Question q : questions) {
            double score = q.grade();
            totalScore += score;
            System.out.printf("%s: %.2f\n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    }
}
