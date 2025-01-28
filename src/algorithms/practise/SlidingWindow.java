package algorithms.practise;

import java.util.Arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5};
        int k = 3;
        System.out.println("arr: " + Arrays.toString(arr) + " k: " + k + " res: " + findMaxSumSubarray(arr, k));
    }

    private static int findMaxSumSubarray(int[] arr, int k) {
        //edge case throw if arr<k
        if(arr.length<k) throw new IllegalArgumentException("arr<k");

        //intialise max and window sum
        int maxSum = 0, windowSum = 0;

        //intiliase first twindow
        for(int i=0; i<k; i++){
            windowSum+=arr[i];
        }

        //set maxsum as first window sum
        maxSum=windowSum;

        //slide window
            //calc new window sum
            //find maaxsum by comparison
        for(int i=k; i<arr.length;i++){
            windowSum+=arr[i]-arr[i-k];
            maxSum=Math.max(maxSum, windowSum);
        }

        //return maxsum
        return maxSum;
    }
}
