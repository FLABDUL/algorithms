package algorithms.example.greedy;

import java.util.Arrays;
import java.util.logging.Logger;

// Helper class for Coin Change Algorithm
class CoinChangeHelper {
    private static final Logger logger = Logger.getLogger(CoinChangeHelper.class.getName());

    // Greedy Iterative approach to find the minimum number of coins
    public int coinChangeGreedy(int[] coins, int amount) {
        Arrays.sort(coins); // Sorting ensures we pick larger denominations first
        int count = 0;
        int remainingAmount = amount;

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= remainingAmount) {
                int numCoins = remainingAmount / coins[i];
                count += numCoins;
                remainingAmount = remainingAmount % coins[i];
//                remainingAmount %= coins[i]
                logger.info("Using " + numCoins + " coin(s) of " + coins[i]);
            }
        }

        return remainingAmount == 0 ? count : -1; // Return -1 if exact change is not possible
    }

    // Recursive approach to find the minimum number of coins (Exponential complexity)
    public int coinChangeRecursive(int[] coins, int amount) {
        if (amount == 0) return 0; // Base case
        if (amount < 0) return Integer.MAX_VALUE; // Invalid case

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChangeRecursive(coins, amount - coin);
            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + result);//+ current coin
            }
        }

        return minCoins;
    }
}

// Main class to test Coin Change methods
public class CoinChange {
    private static final Logger logger = Logger.getLogger(CoinChange.class.getName());

    public static void main(String[] args) {
        CoinChangeHelper helper = new CoinChangeHelper();
        int[] coins = {1, 5, 10, 25};
        int amount = 63;

        logger.info("Starting Coin Change Algorithm for amount: " + amount);

        // Testing greedy approach
        int greedyResult = helper.coinChangeGreedy(coins, amount);
        logger.info("Minimum coins needed (Greedy): " + greedyResult);

        // Testing recursive approach
        int recursiveResult = helper.coinChangeRecursive(coins, amount);
        logger.info("Minimum coins needed (Recursive): " + (recursiveResult == Integer.MAX_VALUE ? -1 : recursiveResult));
    }
}

// ------------------- Bottom Comments Section -------------------
// Pros:
// - Greedy approach is efficient for certain denominations (e.g., US coins) with O(n log n) sorting time.
// - Recursive approach explores all possibilities and ensures an optimal solution if applicable.

// Cons:
// - Greedy approach may fail for certain coin systems where an optimal solution is not achievable.
// - Recursive approach has exponential time complexity (O(2^n)) and is impractical for large amounts.

// Uses:
// - Used in making change for transactions, ATM withdrawals, and vending machines.
// - Helpful in financial calculations and game theory problems.

// Time Complexity:
// - Greedy: O(n log n) (Sorting) + O(n) (Selection) = O(n log n)
// - Recursive: O(2^n) (Exponential growth, impractical for large n)

// Space Complexity:
// - Greedy: O(1) (Constant extra space)
// - Recursive: O(n) (Recursive stack depth)
