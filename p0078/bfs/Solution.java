package leetcode.p0078.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    Queue<List<Integer>> parents = new LinkedList<>();
    parents.add(new ArrayList<>());

    for (int level = 0; level < nums.length; level++) {
      final int size = 1 << level;
      final int num = nums[level]; // to limit build (loop) count.

      // build children. current children will be next parents.
      for (int i = 0; i < size; i++) {
        final List<Integer> node = parents.poll();
        final List<Integer> leftNode = new ArrayList<>(node);
        leftNode.add(num);

        parents.add(leftNode);
        parents.add(node);
      }
    }
    return new ArrayList<>(parents);
  }
}
