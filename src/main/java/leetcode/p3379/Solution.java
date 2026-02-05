package leetcode.p3379;

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        final int n = nums.length;
        final int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int k = nums[i];
            // Normalize to non-negative. Unify all jumps to the right.
            // e.g.,
            // n = 4,
            // -1 == +3
            // -2 == +2
            // -3 == +1
            // -4 == +0
            // -5 == -1 == +3
            // ...
            if (k < 0) {
                // 数学的剰余
                // k = n - (Math.abs(k) % n);

                // Java では負数の剰余は符号付き剰余
                // -5 % 4 = -1   (-(5 % 4))
                // ちなみに, Python では数学的剰余
                // -5 % 4 =  3   (4 * -2 + 3 = -5)
                k = n + (k % n);

                // ↑ 必ず k=[0, n) を保証するために二重で %n をかけても良い
                // k = (n + (k % n)) % n;
            }
            result[i] = nums[(i + k) % n];
        }
        return result;
    }
}
