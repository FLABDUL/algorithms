package algorithms.example.heap_priority_queue;

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;
import java.util.logging.Logger;

class KthLargest {
    private static final Logger logger = Logger.getLogger(KthLargest.class.getName());

    // Iterative approach using Max Heap (PriorityQueue)
    public static int findKthLargestIterative(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
        }

        int kthLargest = -1;
        for (int i = 0; i < k; i++) {
            kthLargest = maxHeap.poll(); // Remove top element k times
        }
        logger.info("Iterative Approach: " + k + "th largest element is " + kthLargest);
        return kthLargest;
    }

    // Recursive approach using QuickSelect algorithm
    public static int findKthLargestRecursive(int[] nums, int k) {
        int index = nums.length - k; // Convert kth largest to kth smallest index
        return quickSelect(nums, 0, nums.length - 1, index);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];//one element left, identical right

        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == k) {
            logger.info("Recursive Approach: " + (nums.length - k) + "th smallest (" + k + "th largest) element found: " + nums[pivotIndex]);
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, right, k);//right portion
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);//need to do left portion now
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];//start rightmost
        int i = left;//pointer left
        for (int j = left; j < right; j++) {//except last melement
            if (nums[j] <= pivot) {//pivot = rightmost value
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);//swap rightmost with pointer, final sorted position
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        logger.info("Given array: " + Arrays.toString(nums));

        // Iterative approach using Max Heap
        int resultIterative = findKthLargestIterative(nums, k);
        logger.info("Result from Iterative Approach: " + resultIterative);

        // Recursive approach using QuickSelect
        int resultRecursive = findKthLargestRecursive(Arrays.copyOf(nums, nums.length), k);
        logger.info("Result from Recursive Approach: " + resultRecursive);
    }
}

// Pros & Cons
// - Max Heap Approach (Iterative):
//   - Pros: Simple to implement, does not modify the input array
//   - Cons: Uses extra space (O(N) for heap), slower than QuickSelect
//   - Time Complexity: O(N log N) due to heap insertions and deletions
//   - Space Complexity: O(N) due to heap storage

// - QuickSelect Approach (Recursive):
//   - Pros: In-place, efficient for large data sets
//   - Cons: Modifies the array, worst-case time complexity can be O(N^2) (but avg is O(N))
//   - Time Complexity: O(N) average case, O(N^2) worst case (if bad pivot chosen repeatedly)
//   - Space Complexity: O(1) if using in-place partitioning (O(log N) for recursion stack)

/*
https://www.youtube.com/watch?v=XEmy13g1Qxc neetcode
heap n operation, pop k times, because max heap, pop costs logn, pop k times tc: n + klogn
quick select similar to quick sort:
partition left half lower right half, randomly pick pivot, decides left/right, do in=place, note not sorted
switch with pivot, then quicksort partition remainder, quick sort tc nlogn, but this  algo look one half only so n (average case)
CAN ALSO sort then return length-k
 */
