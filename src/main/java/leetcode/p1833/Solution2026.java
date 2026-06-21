package leetcode.p1833;

class Solution2026 implements Solution {
    // Counting sort.
    // To get a maximum amount, take a smaller cost first.
    public int maxIceCream(int[] costs, int coins) {
        int limit = 0;
        for (int cost : costs) {
            limit = Math.max(limit, cost);
        }
        final int[] freq = new int[limit + 1];
        for (int cost : costs) {
            freq[cost]++;
        }
        int maxAmount = 0;
        for (int cost = 0; cost < freq.length; cost++) {
            if (freq[cost] == 0) {
                continue;
            }
            final int maxCost = cost * freq[cost];
            if (maxCost > coins) {
                // Discard remainders.
                final int takeable = coins / cost;
                maxAmount += takeable;
                coins -= cost * takeable;
            } else {
                maxAmount += freq[cost];
                coins -= maxCost;
            }
        }
        return maxAmount;
    }
}
