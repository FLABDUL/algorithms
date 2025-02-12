package algorithms.example.sort;

import java.util.Arrays;

public class MergeSort {
//    https://www.youtube.com/watch?v=4VqmGXwpLqc good video explaining algorithm

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        // Print the original array before sorting
        System.out.println("Original array: " + Arrays.toString(array));

        // Call the merge sort function on the entire array
        mergeSort(array, 0, array.length - 1);

        // Print the sorted array after merge sort completes
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    // Merge Sort function: Recursively divides the array into halves and sorts them
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Calculate the middle index of the current segment
            int mid = left + (right - left) / 2;

            // Log the current segment of the array being divided
            System.out.println("Dividing: " + Arrays.toString(Arrays.copyOfRange(array, left, right + 1)));

            // Recursively sort the first half
            mergeSort(array, left, mid);

            // Recursively sort the second half
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves together
            merge(array, left, mid, right);
        }
    }

    // Merge function: Merges two sorted subarrays into a single sorted subarray
    public static void merge(int[] array, int left, int mid, int right) {
        // Determine the sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the values of the subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data from the original array into the temporary arrays
        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[mid + 1 + j];

        // Log the two subarrays being merged
        System.out.println("Merging: Left = " + Arrays.toString(leftArray) + ", Right = " + Arrays.toString(rightArray));

        // Initial indices for iterating through the subarrays
        int i = 0, j = 0;

        // Initial index for placing values in the merged array
        int k = left;

        // Merge the subarrays by selecting the smallest element from each
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left subarray
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right subarray
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

        // Log the state of the array after merging
        System.out.println("After merging: " + Arrays.toString(Arrays.copyOfRange(array, left, right + 1)));
    }
    /**
     * Merge Sort Algorithm
     *
     * Pros:
     * - Stable sorting algorithm (maintains relative order of equal elements)
     * - Guarantees O(n log n) time complexity in all cases
     * - Efficient for sorting linked lists (as merging does not require extra space in linked lists)
     *
     * Cons:
     * - Requires additional O(n) space due to temporary arrays
     * - Not ideal for small datasets due to overhead
     * - Performance suffers compared to QuickSort in most practical cases
     *
     * Uses:
     * - Sorting linked lists (since it does not require random access)
     * - External sorting (when data is too large to fit in memory)
     * - Suitable for parallel sorting due to its divide-and-conquer nature
     *
     * Time Complexity:
     * - Best Case: O(n log n) N for merging linear + logN for splitting array
     * - Average Case: O(n log n)
     * - Worst Case: O(n log n)
     *
     * Space Complexity:
     * - O(n) due to temporary arrays used during merging
     */
}
