import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public char calculateGrade(double average) {
        if (average >= 75) {
            return 'B';
        } else if (average >= 40) {
            return 'D';
        } else if (average >= 60) {
            return 'C';
        } else {
            return 'F';
        }
    }

    public String getName() {
        return name.toUpperCase();
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            
            String name = line.split(" ")[0];
            String marksStr = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
            String[] marksParts = marksStr.split(",");
            
            int[] marks = new int[marksParts.length];
            for (int i = 0; i < marksParts.length; i++) {
                marks[i] = Integer.parseInt(marksParts[i].trim());
            }
            
            Student student = new Student(name, marks);
            double average = student.calculateAverage();
            char grade = student.calculateGrade(average);
            
            System.out.printf("%s: Average %.1f, Grade %c%n", 
                student.getName(), average, grade);
        }
        scanner.close();
    }
}