package week3.assignment_problems;

public class GradeClassifierWithLogicalOperators {
    public static void classifyWithAttendance(int marks, int attendance) {
        if (attendance >= 75 && marks >= 40) {
            if (marks >= 90) {
                System.out.println("Grade: A");
            } else if (marks >= 75) {
                System.out.println("Grade: B");
            } else if (marks >= 60) {
                System.out.println("Grade: C");
            } else {
                System.out.println("Grade: D");
            }
        } else {
            System.out.println("Detained");
        }
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        classifyWithAttendance(82, 80);
        System.out.print("Test 2: ");
        classifyWithAttendance(91, 60);
    }
}