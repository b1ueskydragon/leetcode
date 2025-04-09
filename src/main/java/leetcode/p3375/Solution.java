package leetcode.p3375;

class Solution {
    public int minOperations(int[] nums, int k) {

        // The count of the number is not a matter
        // e.g.,
        // nums=[5,4,2], k=2
        // -> [4,4,2]
        // -> [2,2,2]
        // 2 operations

        // Constraint: 1 <= nums[i] <= 100
        int max = 0;
        final boolean[] isExists = new boolean[101];
        for (int num : nums) {
            isExists[num] = true;
            max = Math.max(num, max);
        }

        // Assume `k` exists in `nums`
        isExists[k] = true;

        int op = 0;
        // Scanning from the highest number
        for (int i = nums.length - 1; i >= 0; i--) {
            if (isExists[nums[i]]) {
                // Consume the number, since the duplicate numbers should be handled as once
                isExists[nums[i]] = false;
                if (nums[i] < k) {
                    return -1;
                }
                // Since the operation should be counted from the second-highest number,
                // we want to skip the highest number immediately
                if (nums[i] == max) {
                    continue;
                }
                op++;
            }
        }

        // Still exists: `k` does not exist in `nums`
        // We need an additional operation to handle it
        return isExists[k] ? op + 1 : op;
    }
}
