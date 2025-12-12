package leetcode.p0145;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        dfs(postorder, root);
        return postorder;
    }

    private void dfs(List<Integer> postorder, TreeNode root) {
        if (root == null) {
            return; // no more children
        }
        dfs(postorder, root.left);
        // left から return して抜け出した先
        dfs(postorder, root.right);
        // right まで探索終わって抜け出した先
        // stack に溜めっていた value を順次 append
        postorder.add(root.val);
    }
}
