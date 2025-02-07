package algorithms.example.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

// Class representing an interval with start and end times
class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Helper class for Interval Scheduling Algorithm
class IntervalSchedulingHelper {
    private static final Logger logger = Logger.getLogger(IntervalSchedulingHelper.class.getName());

    // Greedy iterative approach to select the maximum number of non-overlapping intervals
    public int intervalSchedulingIterative(Interval[] intervals) {
        // Sort intervals based on their end times (Greedy Choice)
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.end));

        int count = 0;
        int lastEndTime = Integer.MIN_VALUE;

        for (Interval interval : intervals) {
            if (interval.start >= lastEndTime) { // If non-overlapping
                count++;
                lastEndTime = interval.end;
                logger.info("Selected interval: (" + interval.start + ", " + interval.end + ")");
            }
        }
        return count;
    }

    // Recursive greedy approach to select maximum non-overlapping intervals
    public int intervalSchedulingRecursive(Interval[] intervals, int index, int lastEndTime) {
        if (index >= intervals.length) return 0; // Base case

        logger.info("Checking interval: (" + intervals[index].start + ", " + intervals[index].end + ")");

        // Option 1: Exclude current interval and move to next
        int exclude = intervalSchedulingRecursive(intervals, index + 1, lastEndTime);

        // Option 2: Include current interval if it doesn't overlap
        int include = 0;
        if (intervals[index].start >= lastEndTime) {
            include = 1 + intervalSchedulingRecursive(intervals, index + 1, intervals[index].end);
        }

        return Math.max(include, exclude); // Return the best option
    }
}

// Main class to test Interval Scheduling
public class IntervalScheduling {
    private static final Logger logger = Logger.getLogger(IntervalScheduling.class.getName());

    public static void main(String[] args) {
        IntervalSchedulingHelper helper = new IntervalSchedulingHelper();
        Interval[] intervals = {
                new Interval(1, 3), new Interval(2, 5), new Interval(3, 6),
                new Interval(5, 8), new Interval(8, 10)
        };

        logger.info("Starting Interval Scheduling Algorithm");

        // Iterative approach
        int iterativeResult = helper.intervalSchedulingIterative(intervals);
        logger.info("Maximum non-overlapping intervals (Iterative): " + iterativeResult);

        // Recursive approach
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.end)); // Sort before recursion
        int recursiveResult = helper.intervalSchedulingRecursive(intervals, 0, Integer.MIN_VALUE);
        logger.info("Maximum non-overlapping intervals (Recursive): " + recursiveResult);
    }
}

// ------------------- Bottom Comments Section -------------------
// Pros:
// - Greedy approach ensures an efficient solution with minimal computation.
// - Iterative solution is highly efficient with O(n log n) complexity due to sorting.

// Cons:
// - Recursive approach is less efficient and can cause stack overflow for large inputs.
// - Greedy does not work for all scheduling problems (e.g., Weighted Interval Scheduling).

// Uses:
// - Used in job scheduling, event planning, and CPU scheduling to maximize non-overlapping tasks.
// - Helps in real-world scenarios like booking conference rooms and scheduling advertisements.

// Time Complexity:
// - Iterative: O(n log n) (Sorting takes O(n log n) + Iteration O(n))
// - Recursive: O(2^n) (Exponential in worst case, not optimal for large n)

// Space Complexity:
// - Iterative: O(1) (Constant extra space)
// - Recursive: O(n) (Recursive stack depth)
