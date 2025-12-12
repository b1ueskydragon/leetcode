package leetcode.p0145;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class SolutionV2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // pop する順番を考えて
        // right child を優先的に積んでいく
        Stack<TreeNode> stack = new Stack<>();

        // となると先頭に追加できる構造がありがたい
        // addFirst operates in O(1) time
        LinkedList<Integer> postorder = new LinkedList<>();
        TreeNode pointer = root;

        while (pointer != null || !stack.isEmpty()) {
            // 優先的に右を見る, なかったら左に行こうするけど, その先も右を優先に見る, の繰り返し
            while (pointer != null) {
                stack.push(pointer);
                postorder.addFirst(pointer.val);
                pointer = pointer.right;
            }
            // at this point, the pointer is null
            // so let's pop from the stack
            pointer = stack.pop();
            pointer = pointer.left;
        }
        return postorder;
    }
}
