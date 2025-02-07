package algorithms.example.dynamic_programming;

import java.util.HashMap;
import java.util.logging.Logger;

// Supplementary class for Fibonacci calculations
class FibonacciHelper {
    private static final Logger logger = Logger.getLogger(FibonacciHelper.class.getName());
    private HashMap<Integer, Long> memoizationCache = new HashMap<>(); // Cache for memoization

    // Recursive Fibonacci with memoization (Optimized)
    public long fibonacciMemoized(int n) {//DIVIDE AND CONQUER and TOP-DOWN APPROACH
        if (n <= 1) return n; // Base cases: fib(0) = 0, fib(1) = 1
        if (memoizationCache.containsKey(n)) {
            logger.info("Cache hit for n = " + n);
            return memoizationCache.get(n);
        }
        logger.info("Computing fibonacciMemoized(" + n + ")");
        long result = fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2);
        memoizationCache.put(n, result); // Store result in cache
        return result;
    }

    // Iterative Fibonacci (Efficient, O(n) time & O(1) space)
    public long fibonacciIterative(int n) {//TABULATION  and BOTTOM-UP APPROACH
        if (n <= 1) return n;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            logger.info("Computing fibonacciIterative(" + i + ")");
            long temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}

// Main class to test Fibonacci methods
public class Fibonacci {
    private static final Logger logger = Logger.getLogger(Fibonacci.class.getName());

    public static void main(String[] args) {
        FibonacciHelper fibonacciHelper = new FibonacciHelper();
        int n = 10; // Change this value to test different cases

        logger.info("Starting Fibonacci calculations for n = " + n);

        // Testing memoized recursive Fibonacci
        long fibMemoizedResult = fibonacciHelper.fibonacciMemoized(n);
        logger.info("Fibonacci Memoized Result for n=" + n + " is: " + fibMemoizedResult);

        // Testing iterative Fibonacci
        long fibIterativeResult = fibonacciHelper.fibonacciIterative(n);
        logger.info("Fibonacci Iterative Result for n=" + n + " is: " + fibIterativeResult);
    }
}

// ------------------- Bottom Comments Section -------------------
// Pros:
// - Recursive (with memoization) avoids redundant calculations and improves performance.
// - Iterative version is space-efficient (O(1) space complexity).

// Cons:
// - Recursive without memoization has an exponential time complexity (O(2^n)).
// - Memoized approach still consumes extra memory due to caching.

// Uses:
// - Fibonacci sequences are used in algorithms, dynamic programming, stock market analysis, etc.

// Time Complexity:
// - Recursive without memoization: O(2^n) (Exponential growth)
// - Recursive with memoization: O(n) (Each number is computed once and stored)
// - Iterative: O(n) (Linear growth, iterating once)

// Space Complexity:
// - Recursive without memoization: O(n) (Call stack depth)
// - Recursive with memoization: O(n) (Cache storage)
// - Iterative: O(1) (Only a few variables are used)

//e.g. memoization: If F(10) was computed before, F(12) = F(11) + F(10), meaning F(10) is directly retrieved from memory, avoiding redundant calls.
