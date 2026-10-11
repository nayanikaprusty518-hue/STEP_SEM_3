import java.util.Scanner;

public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim();
            if (word.isEmpty()) continue;
            
            StringBuilder sb = new StringBuilder(word);
            String reversed = sb.reverse().toString();
            
            boolean isPalindrome = word.equals(reversed);
            
            System.out.println(reversed + (isPalindrome ? " - palindrome" : " - not a palindrome"));
        }
        scanner.close();
    }
}