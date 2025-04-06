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

    static class V2 {

        // Constraints: nums.length <= 20
        // We can use backtracking, but we don't need to generate all subsets

        public int subsetXORSum(int[] nums) {
            return xor(0, nums, 0);
        }

        private int xor(int i, int[] nums, int currentXor) {
            // Reached to a leaf level
            if (i == nums.length) {
                return currentXor;
            }
            // Binary decision tree DFS
            // Scenario: Pick (add) the current node
            int inclCurr = xor(i + 1, nums, currentXor ^ nums[i]);
            // Scenario: Skip the current node
            int exclCurr = xor(i + 1, nums, currentXor);
            return inclCurr + exclCurr;
        }
    }
}
