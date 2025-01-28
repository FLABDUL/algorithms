package algorithms.example.sort;

public class BubbleSort {

    // Bubble Sort function
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop to traverse all elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // To check if a swap occurred in this iteration

            // Inner loop for comparison and swapping
            // Inner loop for comparison and swapping
            for (int j = 0; j < n - i - 1; j++) {//-i-1 to prevent sorting already sorted last element
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Mark that a swap occurred
                }
            }

            // If no swaps occurred, the array is sorted, break early
            if (!swapped) break;
        }
    }

    // Helper method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
