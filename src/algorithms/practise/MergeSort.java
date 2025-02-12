package algorithms.practise;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int left, int right) {
        //left less right if
            //calcualte mid
            //recursive call mergesrot left
            //and right
            //merge halves
        if(left < right){
//            int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;//takes into account of non-zero left and prevents overflow
            mergeSort(array, left, mid);//includes mid as needs processing
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right){
        //get size of left and right
        //create arrats foor both
        //copy original into new
        //initial i j 0
//        index left
        int first = mid - left + 1;//0 index
        int second = right - mid;
        int[] lefties = new int[first];
        int[] righties = new int[second];
        for(int i = 0; i < first; i++){
            lefties[i] = array[left + i];
        }
        for(int j = 0; j < second; j++){
            righties[j] = array[mid + 1 + j];//right subarray begins right afte rmid
        }
        int i = 0;
        int j = 0;
        int k = left;
        //merge subarrays with smaller of two
        while(i < first && j < second){
            if(lefties[i] <= righties[j]){
                array[k] = lefties[i];
                i++;
            }else{
                array[k] = righties[j];
                j++;
            }
            k++;
        }

        //copy remaining left and right
        while(i<first){
            array[k] = lefties[i];
            i++;
            k++;
        }

        while(j<second){
            array[k] = righties[j];
            j++;
            k++;
        }
    }
}
