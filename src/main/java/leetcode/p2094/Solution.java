package leetcode.p2094;

class Solution {
    // Constraint: 3-digit, even numbers, no leading zeros, return a sorted array
    public int[] findEvenNumbers(int[] digits) {
        // n <= 100
        final int n = digits.length;
        final boolean[] exists = new boolean[1000];

        int m = 0;
        // Max 1000000 loops
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if ((digits[k] & 1) == 1) {
                        continue;
                    }
                    final int x = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (exists[x]) {
                        continue;
                    }
                    m++;
                    exists[x] = true;
                }
            }
        }

        final int[] res = new int[m];
        int j = 0;
        for (int i = 0; i < 1000; i++) {
            if (exists[i]) {
                res[j++] = i;
            }
        }
        return res;
    }
}
