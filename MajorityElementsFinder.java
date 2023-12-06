import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MajorityElementsFinder {
    // Method to find majority elements in an array
    public static List<Integer> majorityElements(int[] nums) {
        // Result list to store majority elements
        List<Integer> result = new ArrayList<>();

        // Check if the array is null or empty
        if (nums == null || nums.length == 0) {
            return result; // If so, return an empty result list
        }

        // Initialize candidates and their corresponding counts
        int candidate1 = 0, candidate2 = 1, count1 = 0, count2 = 0;

        // Iterate through the array
        for (int num : nums) {
            // Check if the current number is equal to candidate1
            if (candidate1 == num) {
                count1++; // Increment count1
            } else if (candidate2 == num) {
                count2++; // Increment count2
            } else if (count1 == 0) {
                candidate1 = num; // Update candidate1
                count1 = 1;       // Reset count1
            } else if (count2 == 0) {
                candidate2 = num; // Update candidate2
                count2 = 1;       // Reset count2
            } else {
                count1--; // Decrement count1
                count2--; // Decrement count2
            }
        }

        // Reset counts for candidates and re-count to verify
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            // Count occurrences of candidates
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Check if counts meet the majority condition and add to the result list
        int n = nums.length;
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }

        // Return the result list
        return result;
    }

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create an array to store user-entered elements
        int[] nums = new int[size];

        // Prompt the user to enter the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // Call the majorityElements method with the array
        List<Integer> result = majorityElements(nums);

        // Display the result
        System.out.println("Majority Elements: " + result);

        // Close the Scanner
        scanner.close();
    }
}
