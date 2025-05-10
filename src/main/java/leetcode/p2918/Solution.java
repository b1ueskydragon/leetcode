package leetcode.p2918;

class Solution {
    // Every 0 should be at least 1
    // Numbers which replaced 0 are not a matter, the goal is the minimum equal sum
    // -> Greedy
    public long minSum(int[] nums1, int[] nums2) {
        final long sum1 = sum(nums1);
        final int zeroCount1 = countZero(nums1);
        final long sum2 = sum(nums2);
        final int zeroCount2 = countZero(nums2);

        // Assume every 0 has been replaced to 1
        long cand1 = sum1 + zeroCount1;
        long cand2 = sum2 + zeroCount2;

        if (cand1 == cand2) {
            return cand1;
        }

        // Check if there is room to fill the gap
        if (cand1 < cand2 && zeroCount1 > 0) {
            return cand2;
        }
        if (cand1 > cand2 && zeroCount2 > 0) {
            return cand1;
        }

        return -1;
    }

    private static long sum(int[] xs) {
        long sum = 0;
        for (int x : xs) {
            sum += x;
        }
        return sum;
    }

    private static int countZero(int[] xs) {
        int count = 0;
        for (int x : xs) {
            if (x == 0) {
                count++;
            }
        }
        return count;
    }
}
