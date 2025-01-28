package algorithms.example.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build the heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("Building heap: Calling heapify for index " + i);
            heapify(arr, n, i);
            System.out.println("Heap after heapify at index " + i + ": " + Arrays.toString(arr));
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            System.out.println("\nSwapping root " + arr[0] + " with element " + arr[i] + " at index " + i);
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            System.out.println("Heap after swapping: " + Arrays.toString(arr));

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
            System.out.println("Heap after heapify on reduced heap: " + Arrays.toString(arr));
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Check if left child exists and is greater than root
        if (left < n && arr[left] > arr[largest]) {
            System.out.println("Left child " + arr[left] + " is greater than root " + arr[largest]);
            largest = left;
        }

        // Check if right child exists and is greater than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            System.out.println("Right child " + arr[right] + " is greater than current largest " + arr[largest]);
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            System.out.println("Swapping " + arr[i] + " with " + arr[largest] + " to maintain heap property");
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
}

