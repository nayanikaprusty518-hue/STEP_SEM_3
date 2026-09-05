package week5.class_problems;

import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;
    double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.compositeScore = cgpa * 10 + codingScore * 0.5;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore);
    }

    double getCompositeScore() {
        return compositeScore;
    }

    String getName() {
        return name;
    }
}

public class PlacementDriveEngine {
    public static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) || Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted[count++] = c;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);
        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalList.length; i++) {
            result.append(i + 1).append(". ")
                  .append(finalList[i].getName()).append(" (")
                  .append(String.format("%.1f", finalList[i].getCompositeScore())).append(")");
            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}