package leetcode.p2161;

class Solution2026 implements Solution {

    public int[] pivotArray(int[] nums, int pivot) {
        // 9,12,5,10,14,3,10
        // 9,5,3,  10,10,  12,14
        final int n = nums.length;
        final int[] ans = new int[n];
        // Fill left.
        int l = 0;
        for (int num : nums) {
            if (num < pivot) {
                ans[l++] = num;
            }
        }
        // Fill right.
        int r = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > pivot) {
                ans[r--] = nums[i];
            }
        }
        // Fill middle.
        while (l <= r) {
            ans[l++] = pivot;
        }
        return ans;
    }

}
