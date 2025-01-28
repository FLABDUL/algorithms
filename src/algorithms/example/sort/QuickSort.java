package algorithms.example.sort;

import java.util.Arrays;

public class QuickSort {
    // https://www.youtube.com/watch?v=Vtckgz38QHs good resource

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        // Print the original array before sorting
        System.out.println("Original array: " + Arrays.toString(array));

        // Call the quicksort function on the entire array
        quickSort(array, 0, array.length - 1);

        // Print the sorted array after quicksort completes
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    /**
     * QuickSort function: Recursively sorts the array using divide-and-conquer.
     *
     * Time Complexity:
     * - Best Case: O(n log n) when the pivot divides the array into two equal halves.
     * - Average Case: O(n log n) for a reasonably balanced partition.
     * - Worst Case: O(n^2) when the pivot always divides the array into highly unbalanced partitions (e.g., sorted array with first/last element as pivot).
     *
     * Space Complexity: O(log n) due to recursive stack calls.
     *
     * Pros:
     * - Efficient for large datasets with average case O(n log n).
     * - In-place sorting (requires no extra memory apart from the stack).
     *
     * Cons:
     * - Worst-case performance can degrade to O(n^2).
     * - Not stable (equal elements may not retain their original order).
     *
     * Use Cases:
     * - Useful for sorting arrays and lists efficiently when memory is a constraint.
     * - Frequently used in system-level applications due to its in-place nature.
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(array, low, high);

            // Log the array state after partitioning
            System.out.println("Partitioned at index " + pi + ": " + Arrays.toString(array));

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /**
     * Partition function: Places the pivot element at the correct position and rearranges elements.
     *
     * - Chooses the last element as pivot.
     * - Rearranges the array so that elements smaller than the pivot are on the left,
     *   and elements greater than the pivot are on the right.
     *
     * Time Complexity: O(n), as it iterates through the array once.
     */
    public static int partition(int[] array, int low, int high) {
        // Choose the last element as pivot
        int pivot = array[high];

        // Index of smaller element
        int i = low - 1;

        // Traverse through all elements and compare with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                // Swap elements that are smaller than the pivot
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at i + 1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Log the pivot placement
        System.out.println("Pivot " + pivot + " placed at index " + (i + 1));

        return i + 1;
    }
}
