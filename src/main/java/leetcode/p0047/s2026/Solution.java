package leetcode.p0047.s2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        // Place duplicate elements adjacent, so the left element is chosen first.
        Arrays.sort(nums);
        backtracking(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtracking(
            int[] nums,
            List<List<Integer>> res,
            List<Integer> sub,
            boolean[] seen
    ) {
        if (sub.size() == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (seen[i]) {
                continue;
            }
            // Already sorted,
            // 探索の中で right 要素のあと left 要素を参照する際に duplicate 発生する.
            // e.g.,
            // nums = [1, 1, 2]
            // 1 (index 1) が今見ている curr, 1 (index 0) がこれから add する next の際に, add 1 (index 0) を飛ばす.
            // 1 (index 1) が curr の時, next の 1 (index 0) は一度 not seen 状態に戻されているので, seen check で duplicate 判別可能.
            // sorted なので subset の方の [1, 1, 2] は 1 (index 0) が curr, 1 (index 1) が next だった時代に追加済み.
            if (i > 0 && nums[i - 1] == nums[i] && !seen[i - 1]) {
                continue;
            }
            sub.add(nums[i]);
            seen[i] = true;
            backtracking(nums, res, sub, seen);
            sub.removeLast();
            seen[i] = false;
        }
    }
}
