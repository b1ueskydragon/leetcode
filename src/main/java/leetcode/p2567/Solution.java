package leetcode.p2567;

class Solution {
    // 3 <= n <= 10^5
    // 1 <= nums[i] <= 10^9
    public int minimizeSum(int[] nums) {

        // After ignore (neutralize?) any 2 elements,
        // get the minimum distance of max(nums) - min(nums).
        // In specific, after sorting, compare patterns which ignore
        // 2 heads VS 2 lasts VS 1 head + 1 last.

        final int n = nums.length;
        // Arrays.sort(nums);
        // return Math.min(
        //     nums[n - 1] - nums[2],
        //     Math.min(nums[n - 3] - nums[0], nums[n - 2] - nums[1])
        // );
        int min1 = Integer.MAX_VALUE; // nums[0]
        int min2 = Integer.MAX_VALUE; // nums[1]
        int min3 = Integer.MAX_VALUE; // nums[2]
        int max1 = Integer.MIN_VALUE; // nums[n - 1]
        int max2 = Integer.MIN_VALUE; // nums[n - 2]
        int max3 = Integer.MIN_VALUE; // nums[n - 3]
        for (int num : nums) {
            min3 = Math.min(min3, num);
            if (min2 > min3) {
                int tmp = min2;
                min2 = min3;
                min3 = tmp;
            }
            if (min1 > min2) {
                int tmp = min1;
                min1 = min2;
                min2 = tmp;
            }

            max3 = Math.max(max3, num);
            if (max2 < max3) {
                int tmp = max2;
                max2 = max3;
                max3 = tmp;
            }
            if (max1 < max2) {
                int tmp = max1;
                max1 = max2;
                max2 = tmp;
            }
        }
        return Math.min(max1 - min3, Math.min(max3 - min1, max2 - min2));
    }
}
