package leetcode.p3573;

class Solution {
    // You must complete each transaction before starting another.
    public long maximumProfit(int[] prices, int k) {
        final int n = prices.length;

        // day / transaction / state:
        //   state:
        //     - 0 (The transaction is closed. Ready to open a new one)
        //     - 1 (The transaction is opened. Waiting to close; buy now to sell later)
        //     - 2 (The transaction is opened. Waiting to close; sell now to buy later)
        final long[][][] dp = new long[n][k][3];

        // Initialize: Day 0
        for (int j = 0; j < k; j++) {
            dp[0][j][0] = 0; // Do nothing.
            dp[0][j][1] = -prices[0]; // Buy now.
            dp[0][j][2] = prices[0]; // Sell now.
        }
        // Day 1 to Day N-1
        for (int i = 1; i < n; i++) {
            // At most k transactions
            for (int j = 0; j < k; j++) {

                // Possible transitions:
                // 1 -> 0  or  2 -> 0  or  0 -> 1  or  0 -> 2

                ////// 0 state: Must close the transaction //////

                // Keep the best for state 0.
                dp[i][j][0] = Math.max(
                        // Candidate:
                        // Carry over previous result of state 0.
                        dp[i - 1][j][0],
                        Math.max(
                                // Candidate:
                                // state 1 -> 0
                                // Close the previous transaction to add current price
                                dp[i - 1][j][1] + prices[i],
                                // Candidate:
                                // state 2 -> 0
                                // Close the previous transaction to subtract current price
                                dp[i - 1][j][2] - prices[i]
                        )
                );

                ////// non-0 state: Open the new transaction is allowed //////

                // Keep the best for state 1.
                dp[i][j][1] = Math.max(
                        // Candidate:
                        // Carry over previous result of state 1.
                        dp[i - 1][j][1],
                        // Candidate:
                        // state 0 -> 1
                        // Buy the stock. Open the transaction from the last closed transaction.
                        (j == 0) ? -prices[i] : dp[i - 1][j - 1][0] - prices[i]
                );
                // Keep the best for state 2.
                dp[i][j][2] = Math.max(
                        // Candidate:
                        // Carry over previous result of state 2.
                        dp[i - 1][j][2],
                        // Candidate:
                        // state 0 -> 2
                        // Sell the stock. Open the transaction from the last closed transaction.
                        (j == 0) ? prices[i] : dp[i - 1][j - 1][0] + prices[i]
                );
            }
        }
        // Get a result from the closed one.
        return dp[n - 1][k - 1][0];
    }
}
