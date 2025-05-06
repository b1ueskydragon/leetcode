package leetcode.p1920.s2025;

class Solution {
    // Do it with O(1) Space usage
    public int[] buildArray(int[] nums) {

        // E can hold both a, b:
        // E = a + b * k
        // a = E % k
        // b = E / k

        // Constraint: The upper limit is 1000 (exclusive)
        final int k = 1000;
        final int n = nums.length;

        // Encode
        for (int i = 0; i < n; i++) {
            final int a = nums[i];
            // We need to calculate the value of b = nums[nums[i]] before the modification
            // Since k is large enough, taking the modulo of the non-encoded value also works well
            // NG:
            // final int b = nums[nums[i]];
            // OK:
            final int b = nums[nums[i]] % k;
            nums[i] = a + b * k;
        }

        // Decode b
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / k;
        }

        return nums;
    }
}
