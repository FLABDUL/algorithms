package algorithms.example.listsearch;

import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        // Example array to search
        int[] arr = {5, 2, 9, 1, 5, 6};

        // Target value to search for
        int target = 9;

        // Perform linear search
        int index = linearSearch(arr, target);

        // Output the result
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }

    /**
     * Linear Search Algorithm.
     * Searches for a target value in the given array by checking each element sequentially.
     *
     * @param arr    the array to search through
     * @param target the value to search for
     * @return the index of the target if found, otherwise -1
     */
    public static int linearSearch(int[] arr, int target) {
        // Log the input array and the target value
        System.out.println("Searching for target " + target + " in array: " + Arrays.toString(arr));

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Log the current index and the value being checked
            System.out.println("Checking index " + i + " with value: " + arr[i]);

            if (arr[i] == target) {
                // Log when the target is found
                System.out.println("Target found at index: " + i);
                return i; // Return the index if target is found
            }
        }

        // Log if the target is not found after completing the loop
        System.out.println("Target not found in the array.");
        return -1; // Return -1 if the target is not found
    }

    /*
     * Time Complexity:
     * - Best case: O(1) if the target is found at the first position.
     * - Worst case: O(n) if the target is at the last position or not in the array at all.
     * - Average case: O(n), as we may have to scan most or all of the array.
     *
     * Space Complexity: O(1)
     * - The algorithm only requires a fixed amount of extra space (for variables like 'i').
     *
     * Pros:
     * - Simple to implement and understand.
     * - Doesn't require the array to be sorted.
     *
     * Cons:
     * - Inefficient for large datasets as it potentially checks every element in the array.
     * - Linear time complexity (O(n)) can be slow for large arrays.
     *
     * Use Cases:
     * - When the dataset is small or when the array is unsorted.
     * - If searching for a specific value without needing to sort the array first.
     */
}
