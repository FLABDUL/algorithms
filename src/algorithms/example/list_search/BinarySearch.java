package algorithms.example.list_search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        // Example array to search (must be sorted for binary search to work)
        int[] arr = {1, 2, 5, 5, 6, 9};

        // Target value to search for
        int target = 9;

        // Perform binary search
        int index = binarySearchIterative(arr, target);

        // Output the result
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }

    /**
     * Binary Search Algorithm.
     * Searches for a target value in a sorted array by repeatedly dividing the search interval in half.
     *
     * @param arr    the sorted array to search through
     * @param target the value to search for
     * @return the index of the target if found, otherwise -1
     */
    public static int binarySearchIterative(int[] arr, int target) {
        // Log the input array and target
        System.out.println("Searching for target " + target + " in array: " + Arrays.toString(arr));

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // Log the current search bounds and middle element
            System.out.println("Left: " + left + ", Right: " + right + ", Mid: " + mid + ", Value at Mid: " + arr[mid]);

            // Check if the target is at the middle
            if (arr[mid] == target) {
                // Log when the target is found
                System.out.println("Target found at index: " + mid);
                return mid;
            }

            // If the target is greater, discard the left half
            if (arr[mid] < target) {
                left = mid + 1;
                System.out.println("Target is greater than value at Mid. Moving to the right half.");
            }
            // If the target is smaller, discard the right half
            else {
                right = mid - 1;
                System.out.println("Target is smaller than value at Mid. Moving to the left half.");
            }
        }

        // Log if the target is not found after completing the search
        System.out.println("Target not found in the array.");
        return -1; // Return -1 if the target is not found
    }

    /*
     * Time Complexity:
     * - Best case: O(1) if the target is at the middle.
     * - Worst case: O(log n) as we halve the search space in each iteration.
     * - Average case: O(log n) because we keep dividing the search space in half.
     *
     * Space Complexity: O(1)
     * - Only a few extra variables (left, right, mid) are used, independent of the array size.
     *
     * Pros:
     * - Efficient for large datasets with O(log n) time complexity.
     * - Much faster than linear search for large sorted arrays.
     *
     * Cons:
     * - Requires the array to be sorted.
     * - Can be more complex to implement than linear search.
     *
     * Use Cases:
     * - When dealing with large sorted datasets.
     * - When you need fast search operations on sorted data.
     */

    /**
     * Recursive Binary Search Algorithm.
     * Searches for a target value in a sorted array by dividing the search range in half.
     *
     * @param arr    the sorted array to search
     * @param target the value to find
     * @param left   the left bound of the search range
     * @param right  the right bound of the search range
     * @return the index of the target if found, otherwise -1
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // Base case: If the search space is empty, return -1 (not found)
        if (left > right) {
            System.out.println("Target not found in the array.");
            return -1;
        }

        // Calculate the middle index
        int mid = left + (right - left) / 2;

        // Log the current search range
        System.out.println("Left: " + left + ", Right: " + right + ", Mid: " + mid + ", Value at Mid: " + arr[mid]);

        // Check if the target is at the middle
        if (arr[mid] == target) {
            System.out.println("Target found at index: " + mid);
            return mid;
        }

        // If the target is greater, search in the right half
        if (arr[mid] < target) {
            System.out.println("Target is greater than value at Mid. Moving to the right half.");
            return binarySearch(arr, target, mid + 1, right);
        }

        // If the target is smaller, search in the left half
        System.out.println("Target is smaller than value at Mid. Moving to the left half.");
        return binarySearch(arr, target, left, mid - 1);
    }
}
