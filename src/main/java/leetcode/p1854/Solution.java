package leetcode.p1854;

class Solution {

    private static final int offset = 1950;
    private static final int N = 101;

    public int maximumPopulation(int[][] logs) {
        // 2050 % 1950 = 100
        final int[] freq = new int[N];

        // Mark only boundaries
        for (int[] log : logs) {
            // log[0] < log[1], due to the constraints
            freq[log[0] % offset]++; // New member just joined
            freq[log[1] % offset]--; // One of the members just stepped out
        }

        // Restore from the boundaries
        int maxSum = 0;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            // Non-boundary slots are zeros, so keep summing up is fine
            sum += freq[i];
            if (maxSum < sum) {
                index = i;
                maxSum = sum;
            }
        }

        return index + offset;
    }
}
