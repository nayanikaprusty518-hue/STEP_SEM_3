import java.util.*;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();

    public abstract String getType();
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }

    @Override
    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.toLowerCase().split(",\\s*");
        String studentLower = studentAnswer.toLowerCase();

        int matchCount = 0;
        for (String keyword : keywords) {
            if (studentLower.contains(keyword.trim())) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.5;
        } else {
            return 0;
        }
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        double totalScore = 0;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Question question = parseQuestion(line);
            double score = question.calculateScore();
            totalScore += score;
            System.out.printf("%s: %.2f%n", question.getType(), score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
        scanner.close();
    }

    private static Question parseQuestion(String line) {
        String type = line.split("\\s+")[0];

        int firstQuote = line.indexOf('"');
        int secondQuote = line.indexOf('"', firstQuote + 1);
        String questionText = line.substring(firstQuote + 1, secondQuote);

        int thirdQuote = line.indexOf('"', secondQuote + 1);
        int fourthQuote = line.indexOf('"', thirdQuote + 1);
        String correctAnswer = line.substring(thirdQuote + 1, fourthQuote);

        int fifthQuote = line.indexOf('"', fourthQuote + 1);
        int sixthQuote = line.indexOf('"', fifthQuote + 1);
        String studentAnswer = line.substring(fifthQuote + 1, sixthQuote);

        int points = Integer.parseInt(line.substring(sixthQuote + 1).trim());

        switch (type) {
            case "MCQ":
                return new MCQQuestion(questionText, correctAnswer, studentAnswer, points);
            case "TF":
                return new TFQuestion(questionText, correctAnswer, studentAnswer, points);
            case "ESSAY":
                return new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }
}