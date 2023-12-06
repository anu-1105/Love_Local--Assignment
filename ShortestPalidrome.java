import java.util.Scanner;

public class ShortestPalindrome {
    // Method to find the shortest palindrome by adding characters to the beginning
    public static String shortestPalindrome(String s) {
        // Check if the input string is null or empty
        if (s == null || s.isEmpty()) {
            return s; // If true, return the input string as it is already a palindrome
        }

        // Reverse the input string to create a reversed string
        String reversed = new StringBuilder(s).reverse().toString();

        // Concatenate the original and reversed strings with a special character (#) in between
        String combined = s + "#" + reversed;

        // Compute the Longest Prefix Suffix (LPS) array for the combined string
        int[] lps = computeLPS(combined);

        // Determine the length of the longest prefix in the combined string that is also a suffix
        int prefixLength = lps[lps.length - 1];

        // Extract the suffix from the original string based on the prefix length
        String suffix = s.substring(prefixLength);

        // Reverse the suffix to obtain the required prefix
        String prefix = new StringBuilder(suffix).reverse().toString();

        // Concatenate the prefix and the original string to form the shortest palindrome
        return prefix + s;
    }

    // Method to compute the Longest Prefix Suffix (LPS) array for a given string
    private static int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        // Iterate through the string
        while (i < n) {
            // If characters at indices i and len are equal, increment len and update the LPS array
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // If characters are not equal and len is not 0, update len using the LPS value of the previous index
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    // If characters are not equal and len is 0, set the LPS value at index i to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Return the computed LPS array
        return lps;
    }

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Call the shortestPalindrome method with the user input
        String result = shortestPalindrome(userInput);

        // Display the result
        System.out.println("Shortest Palindrome: " + result);

        // Close the Scanner
        scanner.close();
    }
}
