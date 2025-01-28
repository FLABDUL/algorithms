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
