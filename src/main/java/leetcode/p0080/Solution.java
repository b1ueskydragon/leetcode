package leetcode.p0080;

class Solution {
    // Constraints -10^4 <= nums[i] <= 10^4
    // This represents `_`
    private static final int MARKED = -10001;

    // nums is sorted in non-decreasing order
    // in-place
    public int removeDuplicates(int[] nums) {
        // "然るべき slot" は決まっている.

        // as-is: [0,0,0,0,1,1,1,2,2,2,3,3,4]
        // to-be: [0,0,_,_,1,1,_,2,2,_,3,3,4]
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                // Reset to next num
                count = 1;
                num = nums[i];
            }
            if (count > 2) {
                // Mark redundant nums
                nums[i] = MARKED;
            }
        }

        // as-is: [0,0,_,_,1,1,_,2,2,_,3,3,4]
        // to-be: [0,0,1,1,2,2,3,3,4,_,3,3,4]
        int i = 0;
        int j = i;
        while (j < nums.length) {
            while (i < nums.length && nums[i] != MARKED) {
                i++;
                j = i;
            }
            // Now i is on _
            while (j < nums.length && nums[j] == MARKED) {
                j++;
            }

            if (j < nums.length) {
                // Now j is NOT on _
                int curr = nums[j];
                // Swap to send _ to the right
                while (j < nums.length && nums[j] == curr) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                    j++;
                }
            }
        }

        int answer = 1;
        for (int k = 1; k < nums.length; k++) {
            if (nums[k - 1] > nums[k]) {
                return answer;
            }
            answer++;
        }

        return answer;
    }
}
