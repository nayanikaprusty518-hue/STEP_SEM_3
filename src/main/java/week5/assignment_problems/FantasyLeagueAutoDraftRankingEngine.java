package week5.assignment_problems;

import java.util.Arrays;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;
    double fantasyPoints;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
        this.fantasyPoints = battingAverage;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.fantasyPoints, this.fantasyPoints);
    }

    String getName() {
        return name;
    }

    double getFantasyPoints() {
        return fantasyPoints;
    }
}

public class FantasyLeagueAutoDraftRankingEngine {
    public static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (Player.isDraftable(p.matchesPlayed) || Player.isDraftable(p.matchesPlayed, p.injured)) {
                draftable[count++] = p;
            }
        }

        Player[] finalList = Arrays.copyOf(draftable, count);
        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalList.length; i++) {
            result.append(i + 1).append(". ").append(finalList[i].getName());
            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}