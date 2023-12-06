import java.util.Scanner;
public class LengthOfLastWord {
 public static int lengthOfLastWord(String s) {
 // Trim the string to remove leading and trailing spaces
 String trimmedString = s.trim();
 // Find the last space in the trimmed string
 int lastSpaceIndex = trimmedString.lastIndexOf(' ');
 // If there is no space, the entire trimmed string is the last word
 if (lastSpaceIndex == -1) {
 return trimmedString.length();
 }
 // Extract the last word from the trimmed string
 String lastWord = trimmedString.substring(lastSpaceIndex + 1);
 // Return the length of the last word
 return lastWord.length();
 }
 public static void main(String[] args) {
 // Create a Scanner object to take input from the user
 Scanner scanner = new Scanner(System.in);
 // Prompt the user to enter a string
 System.out.print("Enter a string: ");
 String userInput = scanner.nextLine();
 // Call the lengthOfLastWord function with user input
 int result = lengthOfLastWord(userInput);
 // Display the result
 System.out.println("Length of the last word: " + result);
 // Close the Scanner
 scanner.close();
 }
}