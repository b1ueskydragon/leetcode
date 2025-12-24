package leetcode.p3074;

class Solution {
    // 1 <= n <= 50
    // 1 <= m <= 50
    private static final int LIMIT = 50;

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        final int m = capacity.length;
        final int[] freq = new int[LIMIT + 1];
        for (int c : capacity) {
            freq[c]++;
        }

        int count = 0;
        int i = LIMIT;
        while (sum > 0 && i > 0) {
            final int need = (sum + (i - 1)) / i; // ceil
            if (need >= freq[i]) {
                // freq[i] == 0 also passes this block
                count += freq[i];
                sum -= freq[i] * i;
            } else {
                count += need;
                sum -= need * i;
            }
            i--;
        }
        return count;
    }
}
