package leetcode.p3010;

class Solution {

    private static final int LIMIT = 51;

    public int minimumCost(int[] nums) {
        // The head must be included as the cost.
        final int head = nums[0];

        // Pick 1st, 2nd small elements.
        int first = LIMIT;
        int second = LIMIT;
        for (int i = 1; i < nums.length; i++) {
            if (second < nums[i]) {
                continue;
            }
            second = nums[i];
            if (first > second) {
                // swap
                int tmp = second;
                second = first;
                first = tmp;
            }
        }
        return head + first + second;
    }
}
