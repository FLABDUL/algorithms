package algorithms.example.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        // Print the initial array
        System.out.println("Initial Array:");
        printArray(arr);

        // Perform insertion sort
        insertionSort(arr);

        // Print the sorted array
        System.out.println("Sorted Array:");
        printArray(arr);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Log: Starting to insert the element
            System.out.println("\nConsidering element: " + key);

            // Move elements of arr[0..i-1], that are greater than key, to one position ahead
            // of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;

                // Log: Show array after shifting elements
                System.out.println("After shifting: ");
                printArray(arr);
            }

            // Insert the key at the correct position
            arr[j + 1] = key;

            // Log: Show the array after inserting the element
            System.out.println("Inserted " + key + " at position " + (j + 1));
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
