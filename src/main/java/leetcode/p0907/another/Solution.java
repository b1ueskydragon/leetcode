package leetcode.p0907.another;

import java.util.ArrayList;
import java.util.List;

// the sum of min from all subarrays
class Solution {
    // to filter an empty set's result
    int minimums = -10001;

    // Since the answer may be large, return the answer modulo 10^9 + 7
    // 1 <= arr[i] <= 3 * 10^4
    public int sumSubarrayMins(int[] arr) {
        dfs(arr, 0, new ArrayList<>(), 10001);
        return minimums % 1000000007;
    }

    // backtracking - make a different choice when came back to a root
    // left node: chose to append a new number
    // right node: did not choose to append a new number
    // recursions make a vertical movement and pos makes a horizontal movement on the tree
    // pos is a current position, node is a current node, and min is a current minimum value in the node
    private void dfs(int[] arr, int pos, List<Integer> node, int min) {
        if (pos == arr.length) {
            minimums += min;
            return;
        }

        // recursion - left node
        List<Integer> newNode = new ArrayList<>(node);
        int currVal = arr[pos];
        newNode.add(currVal);
        dfs(arr, pos + 1, newNode, Math.min(min, currVal));

        // recursion - right node
        dfs(arr, pos + 1, node, min);
    }
}
