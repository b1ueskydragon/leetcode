package leetcode.p0113.dfs.backtracking;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> pathSum(TreeNode root,
                                               int targetSum,
                                               List<List<Integer>> paths,
                                               List<Integer> path) {
        if (root == null) {
            return paths;
        }

        final int currStageVal = root.val;

        // keep paths so far (current status) for each node.
        // each node will keep its own path list.
        final List<Integer> currStagePath = new ArrayList<>(path);
        currStagePath.add(currStageVal);

        if (root.left == null && root.right == null && targetSum == currStageVal) {
            paths.add(currStagePath);
            return paths;
        }

        pathSum(root.left, targetSum - currStageVal, paths, currStagePath);
        pathSum(root.right, targetSum - currStageVal, paths, currStagePath);

        return paths;
    }
}
