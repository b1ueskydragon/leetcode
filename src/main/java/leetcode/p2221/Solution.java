package leetcode.p2221;

class Solution {
    public int triangularSum(int[] nums) {
        int sum = 0;
        for (int num : rec(nums)) {
            sum += num;
        }
        return sum;
    }

    private int[] rec(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        final int n = nums.length;
        final int[] newNums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            newNums[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return rec(newNums);
    }
}
