package leetcode.p3707;

class Solution {
    public boolean scoreBalance(String s) {

        // e.g.,
        // num = [1, 2, 3, 2, 4]
        // suffixSum = [12, 11, 9, 6, 4]
        // prefixSum = [1, 3, 6, _, _]
        //                    ↑ The adjacent value of suffixSum
        //                      is equal to current prefixSum.

        final int n = s.length();
        final int[] suffixSum = new int[n];
        // Note: 'a' == 97
        suffixSum[n - 1] = s.charAt(n - 1) - 96;
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + s.charAt(i) - 96;
        }

        int prefixSum = 0;
        for (int i = 0; i < n - 1; i++) {
            prefixSum += s.charAt(i) - 96;
            if (prefixSum == suffixSum[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
