import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MajorityElementsFinder {
 public static List<Integer> majorityElements(int[] nums) {
 List<Integer> result = new ArrayList<>();
 if (nums == null || nums.length == 0) {
 return result;
 }
 int candidate1 = 0, candidate2 = 1, count1 = 0, count2 = 0;
 for (int num : nums) {
 if (candidate1 == num) {
 count1++;
 } else if (candidate2 == num) {
 count2++;
 } else if (count1 == 0) {
 candidate1 = num;
 count1 = 1;
 } else if (count2 == 0) {
 candidate2 = num;
 count2 = 1;
 } else {
 count1--;
 count2--;
 }
 }
 // Reset counts for candidates and re-count to verify
 count1 = 0;
 count2 = 0;
 for (int num : nums) {
 if (num == candidate1) {
 count1++;
 } else if (num == candidate2) {
 count2++;
 }
 }
 int n = nums.length;
 if (count1 > n / 3) {
 result.add(candidate1);
 }
 if (count2 > n / 3) {
 result.add(candidate2);
 }
 return result;
 }
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter the size of the array: ");
 int size = scanner.nextInt();
 int[] nums = new int[size];
 System.out.println("Enter the elements of the array:");
 for (int i = 0; i < size; i++) {
 nums[i] = scanner.nextInt();
 }
 List<Integer> result = majorityElements(nums);
 System.out.println("Majority Elements: " + result);
 scanner.close();
 }
}