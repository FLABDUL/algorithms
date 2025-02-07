package algorithms.example.dynamic_programming;

import java.util.logging.Logger;

// Supplementary class for Knapsack calculations
class KnapsackHelper {
    private static final Logger logger = Logger.getLogger(KnapsackHelper.class.getName());

    // Recursive Knapsack (Exponential Time Complexity O(2^n))
    public int knapsackRecursive(int[] weights, int[] values, int capacity, int n) {
        if (n == 0 || capacity == 0) return 0; // Base case

        if (weights[n - 1] > capacity) {
            return knapsackRecursive(weights, values, capacity, n - 1); // Skip item if it doesn't fit
        }

        logger.info("Computing knapsackRecursive(n = " + n + ", capacity = " + capacity + ")");
        int include = values[n - 1] + knapsackRecursive(weights, values, capacity - weights[n - 1], n - 1);
        int exclude = knapsackRecursive(weights, values, capacity, n - 1);
        return Math.max(include, exclude);//compare both choices
    }

    // Iterative Knapsack using Dynamic Programming (O(n * capacity) Time Complexity)
    public int knapsackIterative(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w]; // Exclude item
                }
                logger.info("dp[" + i + "][" + w + "] = " + dp[i][w]);
            }
        }
        return dp[n][capacity];
    }
}

// Main class to test Knapsack methods
public class Knapsack {
    private static final Logger logger = Logger.getLogger(Knapsack.class.getName());

    public static void main(String[] args) {
        KnapsackHelper helper = new KnapsackHelper();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        logger.info("Starting Knapsack calculations for capacity = " + capacity);

        // Testing recursive Knapsack
        int recursiveResult = helper.knapsackRecursive(weights, values, capacity, weights.length);
        logger.info("Knapsack Recursive Result: " + recursiveResult);

        // Testing iterative Knapsack
        int iterativeResult = helper.knapsackIterative(weights, values, capacity);
        logger.info("Knapsack Iterative Result: " + iterativeResult);
    }
}

// ------------------- Bottom Comments Section -------------------
// Pros:
// - Recursive approach provides a straightforward implementation but is inefficient for large inputs.
// - Iterative dynamic programming approach is more efficient and avoids redundant calculations.

// Cons:
// - Recursive solution has exponential time complexity (O(2^n)), making it infeasible for large n.
// - Iterative DP approach requires additional space O(n * capacity) for storing results.

// Uses:
// - Used in resource allocation, financial budgeting, and logistics optimization.
// - Helps solve real-world problems like maximizing airline cargo load within weight limits.

// Time Complexity:
// - Recursive: O(2^n) (Exponential growth due to multiple recursive calls)
// - Iterative: O(n * capacity) (Efficient but still dependent on input size)

// Space Complexity:
// - Recursive: O(n) (Recursive call stack)
// - Iterative: O(n * capacity) (DP table storage)
