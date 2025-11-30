package leetcode.p0238;

class Solution {
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    // Without division operation, perform in O(n) time.
    public int[] productExceptSelf(int[] nums) {
        // n=4
        //       i_1 x i_2 x i_3     (suffix[1] == 24)
        // i_0 x       i_2 x i_3     (prefix[0] x suffix[2] == 1 x 24)
        // i_0 x i_1 x       i_3     (prefix[1] x suffix[3] == 2 x 4)
        // i_0 x i_1 x i_2           (prefix[2] == 6)
        //
        // nums =   [1, 2, 3, 4]
        // prefix = [1, 2, 6, 24 (prefix product, accumulate left to right)
        // suffix = [24, 24, 12, 4] (suffix product, accumulate right to left)

        final int n = nums.length;
        final int[] prefix = new int[n];
        final int[] suffix = new int[n];
        final int[] ans = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            suffix[n - i - 1] = suffix[n - i] * nums[n - i - 1];
        }

        // n=5
        //       i_1 x i_2 x i_3 x i_4  (suffix[1])
        // i_0 x       i_2 x i_3 x i_4  (prefix[0] * suffix[2])
        // i_0 x i_1 x       i_3 x i_4  (prefix[1] * suffix[3])
        // i_0 x i_1 x i_2       x i_4  (prefix[2] * suffix[4])
        // i_0 x i_1 x i_2 x i_3        (prefix[3])
        ans[0] = suffix[1];
        ans[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = prefix[i - 1] * suffix[i + 1];
        }
        return ans;
    }
}
