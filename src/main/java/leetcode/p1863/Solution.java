package leetcode.p1863;

import java.util.LinkedList;

class Solution {
    static class V1 {

        // Constraints: nums.length <= 20
        // We can use backtracking

        private int outerRes;

        public int subsetXORSum(int[] nums) {
            dfs(0, nums, new LinkedList<>());
            return outerRes;
        }

        private void dfs(int start, int[] nums, LinkedList<Integer> sub) {
            int xor = 0;
            for (int num : sub) {
                xor ^= num;
            }
            outerRes += xor;

            for (int i = start; i < nums.length; i++) {
                sub.addLast(nums[i]); // pick a current position
                dfs(i + 1, nums, sub); // going deeper from the current position
                sub.removeLast(); // backtracking: revert to the status (pick the current -> not-pick the current)
            }
        }
    }
}
