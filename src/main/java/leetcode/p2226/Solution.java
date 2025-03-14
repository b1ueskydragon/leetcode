package leetcode.p2226;

class Solution {
    // Constraints:
    // each element in candies can be divided but we cannot merge two elements together
    public int maximumCandies(int[] candies, long k) {
        // e.g.,
        // [6, 2, 11, 6], k=4
        // [5x1, 5x0, 5x2, 5x1] (ingore remainders), 1 + 0 + 2 + 1 >= k (OK)
        // Then how can we find `5`? -> Try to a middle value first, and binary search
        // Note: The answer number is no need to be included in candies

        // Not indices, values
        // Constraints:
        // Still each candies[i] is an Integer (<= 10^7)
        int left = 1; // 0 candies per person is nonsense
        int right = 1; // Constraints: At least one candy exsits
        for (int candy : candies) {
            right = Math.max(right, candy);
        }

        int allocation = 0;

        while (left <= right) {
            int x = left + (right - left) / 2;

            // Constraints: k <= 10^12, sum can be long
            long people = 0;
            for (int candy : candies) {
                people += candy / x;
            }
            if (people < k) {
                // we need to divide by bigger number
                // an allocation per person should be less
                right = x - 1;
            } else {
                // we can allocate candies to each people
                allocation = x;
                // still we can try to divide by smaller number
                // if possible, we prefer to allocate more per person
                left = x + 1;
            }
        }

        return allocation;
    }
}
