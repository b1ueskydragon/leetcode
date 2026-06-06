package leetcode.p2574;

class Solution {
    // 1000 * 100000 < Integer.MAX_VALUE
    public int[] leftRightDifference(int[] nums) {
        // 10,         4,        8 ,       3
        // 10         10+4    10+4+8   10+4+8+3
        // 3+8+4+10   3+8+4      3+8       3

        // 10 -> 3+8+4 - 0
        // 4  -> 3+8   - 10
        // 8  -> 3     - 10+4
        // 3  -> 0     - 10+4+8

        final int n = nums.length;
        int leftAcc = 0;
        for (int num : nums) {
            leftAcc += num;
        }
        int rightAcc = 0;
        for (int i = 0; i < n; i++) {
            int tmp = nums[i];
            leftAcc -= tmp;
            nums[i] = Math.abs(leftAcc - rightAcc);
            rightAcc += tmp;
        }
        return nums;
    }
}
