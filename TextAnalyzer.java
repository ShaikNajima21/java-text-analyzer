
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class TextAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String again = "y";

        while (again.equalsIgnoreCase("y")) {

            System.out.print("Enter a sentence: ");
            String text = sc.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Please enter a valid sentence.");
                continue;
            }

            int characters = text.length();

            String[] words = text.split("\\s+");

            System.out.println("Characters: " + characters);
            System.out.println("Words: " + words.length);

            System.out.println("Vowels: " + countVowels(text));
            System.out.println("Consonants: " + countConsonants(text));

            System.out.println("Longest word: " + longestWord(words));
            System.out.println("Title case: " + toTitleCase(words));

            System.out.println("Reversed: " + reverseText(text));

            System.out.println("Palindrome: " +
                    (isPalindrome(text) ? "yes" : "no"));

            System.out.println("Word lengths: " + wordLengths(words));

            System.out.println("Most common letter: " +
                    mostCommonLetter(text));

            System.out.print("Word to count: ");
            String searchWord = sc.nextLine().trim();

            System.out.println("Appears: " +
                    countWord(words, searchWord));

            System.out.print("Analyze another? (y/n): ");
            again = sc.nextLine().trim();
        }

        System.out.println("Bye!");

        sc.close();
    }

    static int countVowels(String text) {

        int count = 0;

        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);

            if ("aeiou".indexOf(c) >= 0) {
                count++;
            }
        }

        return count;
    }

    static int countConsonants(String text) {

        int count = 0;

        for (int i = 0; i < text.length(); i++) {

            char c = Character.toLowerCase(text.charAt(i));

            if (Character.isLetter(c) &&
                    "aeiou".indexOf(c) == -1) {
                count++;
            }
        }

        return count;
    }

    static String longestWord(String[] words) {

        String longest = "";

        for (int i = 0; i < words.length; i++) {

            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return longest;
    }

    static String toTitleCase(String[] words) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            result.append(word.substring(0, 1).toUpperCase());
            result.append(word.substring(1).toLowerCase());
            result.append(" ");
        }

        return result.toString().trim();
    }

    static String reverseText(String text) {

        return new StringBuilder(text).reverse().toString();
    }

    static boolean isPalindrome(String text) {

        StringBuilder cleaned = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char c = Character.toLowerCase(text.charAt(i));

            if (Character.isLetter(c)) {
                cleaned.append(c);
            }
        }

        if (cleaned.length() == 0) {
            return false;
        }

        String original = cleaned.toString();
        String reversed = cleaned.reverse().toString();

        return original.equals(reversed);
    }

    static String wordLengths(String[] words) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            result.append(words[i]);
            result.append(" (");
            result.append(words[i].length());
            result.append(")");

            if (i < words.length - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    static String mostCommonLetter(String text) {

        Map<Character, Integer> counts = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {

            char c = Character.toLowerCase(text.charAt(i));

            if (Character.isLetter(c)) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }

        if (counts.isEmpty()) {
            return "none";
        }

        char mostCommon = '\0';
        int highestCount = 0;

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {

            if (entry.getValue() > highestCount) {
                mostCommon = entry.getKey();
                highestCount = entry.getValue();
            }
        }

        return mostCommon + " (" + highestCount + ")";
    }

    static int countWord(String[] words, String searchWord) {

        int count = 0;

        for (int i = 0; i < words.length; i++) {

            if (words[i].equalsIgnoreCase(searchWord)) {
                count++;
            }
        }

        return count;
    }
}
