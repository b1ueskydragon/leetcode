package leetcode.p3432;

class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = nums[0];
        int rightSum = sum - nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((rightSum - leftSum) % 2 == 0) {
                ans++;
            }
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return ans;
    }
}
