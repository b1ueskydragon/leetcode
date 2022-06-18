package leetcode.p0589;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<Integer> res = new ArrayList<>();

    // Each group of children is separated by the null value
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        // repeat the process in order from the top of the list
        for (Node node : root.children) {
            preorder(node);
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
