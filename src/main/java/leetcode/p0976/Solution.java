package leetcode.p0976;

import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {

        // Monotonically sorted nums:
        // e.g.,
        // 1, 2, 2, 5, 7
        //       i  j  k
        // (7, 5, 2) で作れないのなら現在の i より左の i では作れない
        // 作れる場合はそれが最大の sum になる
        //
        // 1, 2, 2, 5, 6
        // (6, 5, 2) で作れるとわかった場合
        // (5, 2, 2) を確認する必要はない
        //
        // v >= 1,
        // 全ての
        // v, v, 2v-1, 3v-2, 5v-4
        // (2v-1) + (3v-2) + (5v-4) が常に v + (2v-1) + (3v-2) より大なりイコール

        Arrays.sort(nums);
        final int n = nums.length;
        for (int k = n - 1; k >= 2; k--) {
            int j = k - 1;
            int i = j - 1;
            if (nums[i] + nums[j] > nums[k]) {
                return nums[i] + nums[j] + nums[k];
            }
        }
        return 0;

    }
}
