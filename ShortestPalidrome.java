import java.util.Scanner;
public class ShortestPalidrome {
 public static String ShortestPalidrome(String s) {
 if (s == null || s.isEmpty()) {
 return s;
 }
 String reversed = new StringBuilder(s).reverse().toString();
 String combined = s + "#" + reversed;
 int[] lps = computeLPS(combined);
 int prefixLength = lps[lps.length - 1];
 String suffix = s.substring(prefixLength);
 String prefix = new StringBuilder(suffix).reverse().toString();
 return prefix + s;
 }
 private static int[] computeLPS(String s) {
 int n = s.length();
 int[] lps = new int[n];
 int len = 0; // length of the previous longest prefix suffix
 int i = 1;
 while (i < n) {
 if (s.charAt(i) == s.charAt(len)) {
 len++;
 lps[i] = len;
 i++;
 } else {
 if (len != 0) {
 len = lps[len - 1];
 } else {
 lps[i] = 0;
 i++;
 }
 }
 }
 return lps;
 }
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter a string: ");
 String userInput = scanner.nextLine();
 String result = ShortestPalidrome(userInput);
 System.out.println("Shortest Palindrome: " + result);
 scanner.close();
 }
}