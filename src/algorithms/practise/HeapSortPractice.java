package algorithms.practise;

import java.util.Arrays;

public class HeapSortPractice {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        //length
        int length = arr.length;

        //build heap
            //call heapify
        for(int i = length/2 - 1; i>=0; i--){
            heapify(arr, length, i);
        }

        //extract heap
            //heapify again
        for(int i = length-1; i>0; i--){
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int length, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < length && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < length && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest !=i){
            int swap = arr[i];
            arr[i] =arr[largest];
            arr[largest]=swap;
            heapify(arr, length, largest);
        }
    }

    //heapify method
        //largest, left right

        //check left largest?

        //check right largest?

        //if largest not root then swap
            //heapify recursviely

}
