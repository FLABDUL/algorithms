package algorithms.example.misc;

import java.util.*;

public class SlidingWindow {

    // Find the maximum sum of a subarray of size k
    public static int findMaxSumSubarray(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array length must be at least k.");
        }

        int maxSum = 0, windowSum = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;
        System.out.println("Initial window sum: " + windowSum);

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element, remove first element of the previous window
            maxSum = Math.max(maxSum, windowSum);
            System.out.println("Window updated: Added " + arr[i] + ", Removed " + arr[i - k] + ", New window sum: " + windowSum);
        }

        System.out.println("Max sum found: " + maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        // Test case
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Subarray size (k): " + k);

        int result = findMaxSumSubarray(arr, k);

        System.out.println("Maximum sum of subarray of size " + k + ": " + result);
    }
}

/*
Pros:
1. Efficient: Time complexity is O(n), as the array is traversed once.
2. Sliding window avoids redundant calculations, making it faster than brute force approaches.

Cons:
1. Fixed window size: Only works for problems where the window size is predefined.
2. Not ideal for dynamic window size problems without modifications.

Space Complexity:
- O(1): The algorithm uses a fixed amount of additional space regardless of input size.

Time Complexity:
- O(n): Each element is added and removed from the window exactly once.

Use Cases:
1. Maximum/minimum sum or product of subarrays.
2. Longest substring problems (e.g., finding substrings with unique characters).
3. Pattern detection in streams or time-series data.
*/

