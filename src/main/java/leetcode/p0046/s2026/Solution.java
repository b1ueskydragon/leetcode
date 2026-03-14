package leetcode.p0046.s2026;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Constraint: All the integers of nums are unique. 1 <= nums.length <= 6.
    public List<List<Integer>> permute(int[] nums) {
        // res will be shared in overall processes.
        final List<List<Integer>> res = new ArrayList<>();
        // nums is a small array, using a boolean array instead of an integer set.
        backtracking(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtracking(
            int[] nums,
            List<List<Integer>> res,
            List<Integer> sub,
            boolean[] seen
    ) {
        // Fixed-length backtracking.
        if (sub.size() == nums.length) {
            // A valid sub is completed.
            // To prevent a sharing same object reference, copying to the new instane.
            res.add(new ArrayList<>(sub));
            return;
        }
        // Ingredient is nums.
        for (int i = 0; i < nums.length; i++) {
            if (seen[i]) {
                continue;
            }
            // Choose.
            sub.add(nums[i]);
            // Memo the chosen index to avoid duplicate choice.
            seen[i] = true;

            backtracking(nums, res, sub, seen);

            // Cancel the latest choice.
            sub.removeLast();
            // Remove from the memo to prepare the next process.
            seen[i] = false;
        }
    }
}
