
import java.util.Scanner;

public class TextAnalyzer {

    public static int countVowels(String text) {
        int count = 0;
        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            if ("aeiou".indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }

        return count;
    }

    public static int countConsonants(String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));

            if (c >= 'a' && c <= 'z' && "aeiou".indexOf(c) == -1) {
                count++;
            }
        }

        return count;
    }

    public static String longestWord(String[] words) {
        String longest = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return longest;
    }

    public static String titleCase(String[] words) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(words[i].substring(0, 1).toUpperCase());
            result.append(words[i].substring(1).toLowerCase());
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static int countWord(String[] words, String search) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(search)) {
                count++;
            }
        }

        return count;
    }

    public static void mostCommonLetter(String text) {
        int[] frequency = new int[26];

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));

            if (c >= 'a' && c <= 'z') {
                frequency[c - 'a']++;
            }
        }

        int max = 0;
        char common = ' ';

        for (int i = 0; i < 26; i++) {
            if (frequency[i] > max) {
                max = frequency[i];
                common = (char) (i + 'a');
            }
        }

        if (max == 0) {
            System.out.println("Most common letter: none");
        } else {
            System.out.println("Most common letter: " + common + " (" + max + ")");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String again = "y";

        while (again.equalsIgnoreCase("y")) {

            System.out.println("=== Text Analyzer ===");
            System.out.print("Enter a sentence: ");

            String text = sc.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Please enter a sentence.");
                continue;
            }

            System.out.println("Characters: " + text.length());

            String[] words = text.split("\\s+");

            System.out.println("Words: " + words.length);

            System.out.println("Vowels: " + countVowels(text));

            System.out.println("Consonants: " + countConsonants(text));

            System.out.println("Longest word: " + longestWord(words));

            System.out.println("Title case: " + titleCase(words));

            String reversed = new StringBuilder(text).reverse().toString();

            System.out.println("Reversed: " + reversed);

            StringBuilder cleaned = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                char c = Character.toLowerCase(text.charAt(i));

                if (Character.isLetter(c)) {
                    cleaned.append(c);
                }
            }

            String original = cleaned.toString();

            String reverseCheck = new StringBuilder(original).reverse().toString();

            if (original.equals(reverseCheck)) {
                System.out.println("Palindrome: yes");
            } else {
                System.out.println("Palindrome: no");
            }

            System.out.print("Word lengths: ");

            for (int i = 0; i < words.length; i++) {
                System.out.print(words[i] + " (" + words[i].length() + ")");

                if (i < words.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();

            mostCommonLetter(text);

            System.out.print("Word to count: ");

            String search = sc.nextLine().trim();

            System.out.println("Appears: " + countWord(words, search));

            System.out.print("Analyze another? (y/n): ");

            again = sc.nextLine().trim();
        }

        System.out.println("Bye!");

        sc.close();
    }
}
