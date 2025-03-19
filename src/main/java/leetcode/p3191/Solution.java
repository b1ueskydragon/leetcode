package leetcode.p3191;

class Solution {
    // Constraints:
    // Choose any 3 `consecutive` elements from the array and flip ALL of them.
    public int minOperations(int[] nums) {
        // Fixed window
        // l   r
        // 1 _ _ <--- NG. When we flip 1->0, We can't retrieve back to flip 0->1 again
        // 0 _ _ <--- OK. We can try to flip 0->1
        final int n = nums.length;
        int l = 0;
        int r = l + 2;
        int count = 0;
        while (r < n) {
            if (nums[l] == 0) {
                flipInplace(nums, l, r);
                count++;
            }
            l++;
            r++;
        }

        for (int i = n - 3; i < n; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }
        return count;
    }

    private static void flipInplace(int[] nums, int l, int r) {
        for (int i = l; i <= r; i++) {
            nums[i] ^= 1;
        }
    }
}
