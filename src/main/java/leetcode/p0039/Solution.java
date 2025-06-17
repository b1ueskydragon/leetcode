package leetcode.p0039;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // Same number may be chosen from candidates an unlimited number of times
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        find(candidates, 0, target, path, res);
        return res;
    }

    private void find(int[] xs, int start , int target, LinkedList<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            // Cannot build a target sum
            return;
        }
        if (target == 0) {
            // Since the list is mutable, we need a copy
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i < xs.length; i++) {
            // 選ぶ
            path.add(xs[i]);
            // 再帰の中で i を使い倒し (target が return の条件に至るまで掘り下げる)
            // 重複しないように後ろには戻さない, そのため i = start
            // 元に戻ったらようやく for-loop を進める
            find(xs, i, target - xs[i], path, res);
            // 選んで掘り下げたあとは元に戻す
            path.removeLast();
        }
    }
}
