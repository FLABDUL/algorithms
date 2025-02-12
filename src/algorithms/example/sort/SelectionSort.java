package algorithms.example.sort;

public class SelectionSort {

    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        System.out.println("Starting Selection Sort:");
        System.out.println("------------------------");

        // Outer loop for iterating through each position in the array
        for (int i = 0; i < n - 1; i++) {
            // Log the current pass
            System.out.println("\nPass " + (i + 1) + ":");
            System.out.println("Array state: ");
            printArray(arr);

            // Find the minimum element in the unsorted portion of the array
            int minIndex = i; // Assume the first element is the smallest
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }

            // Log the element selected as the minimum
            System.out.println("Minimum element selected: " + arr[minIndex]);

            // Swap the found minimum element with the first element of the unsorted portion
            if (minIndex != i) {
                System.out.println("Swapping elements: " + arr[i] + " and " + arr[minIndex]);
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            } else {
                System.out.println("No swap needed as the current element is already the minimum.");
            }
        }

        System.out.println("\nSorting complete.");
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test selection sort with logging
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(arr);

        // Perform selection sort
        selectionSort(arr);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }
}

//brief explanation https://www.youtube.com/watch?v=g-PGLbMth_g

/*
 * Selection Sort Algorithm
 *
 * Time Complexity:
 * - Best, Average, and Worst Case: O(n^2)
 *   Selection Sort always performs O(n^2) comparisons and swaps regardless of the initial order of the elements in the array.
 *   This is because it iterates over the array and finds the minimum element for each index.
 * - Thus, the time complexity is quadratic (O(n^2)), making it inefficient for large datasets.
 *
 * Space Complexity:
 * - O(1) (Constant Space Complexity)
 *   Selection Sort is an in-place sorting algorithm, meaning it requires no extra space for sorting. The sorting is done by swapping elements within the array.
 *   Only a constant amount of space is used for variables like `minIndex` and `temp` in the swapping process.
 *
 * Pros:
 * - Simple and easy to understand.
 * - It performs well for small datasets or nearly sorted arrays.
 * - Selection Sort is an in-place sorting algorithm, which means it does not require additional memory (apart from a few temporary variables).
 *
 * Cons:
 * - Inefficient for large datasets (quadratic time complexity O(n^2)).
 * - It performs a large number of comparisons, even if the array is nearly sorted, which makes it slower compared to more efficient algorithms like Quick Sort, Merge Sort, or even Insertion Sort in most cases.
 *
 * Use Cases:
 * - Selection Sort is rarely used in practical applications due to its inefficiency. However, it can be useful in situations where:
 *   1. Memory usage is limited (since it uses O(1) extra space).
 *   2. The dataset is small or nearly sorted, so the inefficiency of O(n^2) is not a significant problem.
 *   3. Its simplicity is valuable for educational purposes and understanding sorting algorithms.
 *
 * Summary:
 * - Selection Sort is a simple, in-place sorting algorithm with a time complexity of O(n^2) and space complexity of O(1).
 * - It is generally not used in practice for large datasets, but can be useful in certain cases where memory is constrained, or simplicity is a key factor.
 */
