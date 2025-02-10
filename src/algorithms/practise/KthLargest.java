package algorithms.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    //find kth largest method takes nums and k ITERATIVE
        //setup a maxheap priority queue and reverse the ordeer
        //cycle through and add to heap
        //set kth largest to -1 (invalid)
        //poll each element of k times
        //return
    private int kthLargestIterative(int[] nums, int k){
        int kthLargest;
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : nums){
            maxHeap.offer(num);
        }
        kthLargest = -1;//invalid
        for(int i=0; i<k; i++){
            kthLargest = maxHeap.poll();
        }

        return kthLargest;
    }

    /*find recursive method*/
        //convert kth largest to actual index
        //call quickselect
    private int kthLargestRecursive(int[] nums, int k){
        int index = nums.length - k;
        return quickSelect(nums, 0, nums.length-1, index);
    }

    /*quickselect*/
        //if equal start left
        //partition index
        //return quickselect left/right depending on pivot
    private int quickSelect(int[] nums, int left, int right, int index) {
        if(left==right){
            return nums[left];//equal numbers
        }

        int pivotIndex = partition(nums, left, right);

        if(pivotIndex==index){
            return nums[pivotIndex];
        }else if(pivotIndex<index){
            return quickSelect(nums, pivotIndex+1, right, index);//take right to right of pivot
        }else{
            return quickSelect(nums, left, pivotIndex-1, index);//take left to left of pivot
        }
    }

    /*partition*/
    //pivot rightmost
    //pointer leftmost
    //cycle, check pivot, swap
    //swap rightmost pointer
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int index = left;
        for(int j=left; j<right; j++){
            if(nums[j]<pivot){
                swap(nums, index, j);
                index++;
            }
        }
        swap(nums, index, right);
        return index;
    }

    /*swap method*/
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }






    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        KthLargest kthLargest = new KthLargest();
        // Iterative approach using Max Heap
//        int resultIterative = kthLargest.kthLargestIterative(nums, k);
//        System.out.println(resultIterative);

        // Recursive approach using QuickSelect
        int resultRecursive = kthLargest.kthLargestRecursive(Arrays.copyOf(nums, nums.length), k);
        System.out.println(resultRecursive);
    }


}
