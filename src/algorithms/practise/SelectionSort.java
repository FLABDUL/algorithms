package algorithms.practise;

import java.util.Arrays;

public class SelectionSort {
    /*selectionsort takes in array*/
        //length
        //loop each element in array except last
        //take min index as first element
        //loop others including last
        //current less than min?
            //new minindex!
    static void selectionSort(int[] array){
        int length = array.length;
        for(int i=0; i< length - 1; i++){
            int minIndex = i;
            for(int j=i+1; j<length; j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    //if min is not at current index
        //swap


    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.printf(Arrays.toString(arr));
    }
}
