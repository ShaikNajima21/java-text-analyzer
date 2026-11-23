import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String again = "y";

        while (again.equalsIgnoreCase("y")) {

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine().trim();

        if(text.isEmpty()) {
            System.out.println("Please enter a valid sentence.");
            continue;
        }

        int characters = text.length();

        String[] words = text.split("\\s+");
        int wordCount = words.length;

        System.out.println("Characters: " + characters);
        System.out.println("Words: " + wordCount);

        int vowels = countVowels(text);
        System.out.println("Vowels: " + vowels);

        System.out.println("Longest word: " + longestWord(text));
        System.out.println("Title case: " + toTitleCase(text));

        System.out.println("Reversed: " + reverseText(text));

        System.out.println("Palindrome: " + (isPalindrome(text) ? "yes" : "no"));

        System.out.print("Analyze another? (y/n): ");
        again = sc.nextLine().trim();
    }

        System.out.println("Bye!");

        sc.close();
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

    String reversed = cleaned.reverse().toString();

    return cleaned.toString().equals(reversed);
}

    static int countVowels(String text) {
        int count = 0;

        text = text.toLowerCase();

        for(int i=0; i < text.length(); i++) {
            char c = text.charAt(i);

            if("aeiou".indexOf(c) >= 0) {
                count++;
            }
        }

        return count;
    }

    static String longestWord(String text) {
        String[] words = text.split("\\s+");
        String longest = "";

        for(int i=0; i < words.length; i++) {
            if(words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return longest;
    }

    static String toTitleCase(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for(int i=0; i < words.length; i++) {
            String word = words[i];

            result.append(word.substring(0,1).toUpperCase());
            result.append(word.substring(1).toLowerCase());
            result.append(" ");
        }

        return result.toString().trim();
    }
}
