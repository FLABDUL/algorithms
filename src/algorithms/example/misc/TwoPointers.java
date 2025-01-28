package algorithms.example.misc;

import java.util.*;

public class TwoPointers {

    /**
     * Finds all pairs in a sorted array that sum up to a specific target.
     * @param arr Sorted input array.
     * @param target Target sum.
     * @return List of pairs (as integer arrays).
     */
    public static List<int[]> findPairsWithSum(int[] arr, int target) {
        // Result to store pairs
        List<int[]> result = new ArrayList<>();

        // Initialize two pointers
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Starting two-pointers algorithm");

        while (left < right) {
            int sum = arr[left] + arr[right];
            System.out.printf("Checking pair: (%d, %d) => Sum: %d\n", arr[left], arr[right], sum);

            if (sum == target) {
                System.out.printf("Found pair: (%d, %d)\n", arr[left], arr[right]);
                result.add(new int[]{arr[left], arr[right]});
                left++;
                right--; // Move both pointers inward
            } else if (sum < target) {
                System.out.printf("Sum %d is less than target %d, moving left pointer\n", sum, target);
                left++; // Move the left pointer rightward
            } else {
                System.out.printf("Sum %d is greater than target %d, moving right pointer\n", sum, target);
                right--; // Move the right pointer leftward
            }
        }

        System.out.println("Two-pointers algorithm completed.");
        return result;
    }

    public static void main(String[] args) {
        // Example input
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 10;

        System.out.printf("Input array: %s\n", Arrays.toString(arr));
        System.out.printf("Target sum: %d\n", target);

        // Execute the two-pointers algorithm
        List<int[]> pairs = findPairsWithSum(arr, target);

        // Print results
        if (pairs.isEmpty()) {
            System.out.println("No pairs found.");
        } else {
            System.out.println("Pairs found:");
            for (int[] pair : pairs) {
                System.out.printf("(%d, %d)\n", pair[0], pair[1]);
            }
        }
    }

    /**
     * Notes:
     * Pros:
     * - Efficient for sorted arrays (O(n) time complexity).
     * - Simple to implement and easy to understand.
     * - In-place algorithm with O(1) space complexity.
     *
     * Cons:
     * - Requires sorted input. If unsorted, sorting incurs O(n log n) cost.
     * - Not suitable for all problems (e.g., those requiring multiple passes over the array).
     *
     * Use Cases:
     * - Finding pairs with specific properties in sorted data.
     * - Partitioning problems, such as segregating positive and negative numbers.
     * - Two-sum variants in sorted arrays.
     *
     * Time Complexity:
     * - O(n), where n is the length of the array.
     *
     * Space Complexity:
     * - O(1), as it uses no additional space except for variables.
     */
}
