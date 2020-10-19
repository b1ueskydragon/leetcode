package leetcode.p0784.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Has a different tree generation feature to backtracking one.
 *
 * bfs
 *
 *                 [ ]
 *         [ab1]         [Ab1]   -- left node is same as parent (without variation), right node is a new node with taking variation
 *      [ab1] [aB1]   [Ab1] [AB1]
 *     [ab1] [aB1]   [Ab1] [AB1]
 *
 * backtracking
 *                 [ ]
 *            [a]       [A]     -- candidates of each stage. make a different choice after coming back from the each recursion
 *          [b] [B]   [b] [B]
 *         [1] [1]   [1] [1]
 */
class Solution {
  // bfs
  public List<String> letterCasePermutation(String S) {
    final Queue<String> queue = new LinkedList<>();
    queue.add(S);
    for (int stage = 0; stage < S.length(); stage++) {
      final char curr = S.charAt(stage);

      // restrict `add` for each stage
      final int addLimitMax = queue.size();
      for (int i = 0; i < addLimitMax; i++) {
        final String currNode = queue.poll();
        queue.add(currNode);

        if (Character.isDigit(curr)) {
          continue;
        }

        // new instance
        final char[] newNode = currNode.toCharArray();
        newNode[stage] = Character.isLowerCase(curr) ? Character.toUpperCase(curr) : Character.toLowerCase(curr);
        queue.add(new String(newNode));
      }
    }
    return new ArrayList<>(queue);
  }
}
