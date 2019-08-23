package leetcode.p0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    dfs(nums, 0, new ArrayList<>(), res);
    return res;
  }

  private void dfs(int[] nums, int depth, List<Integer> chunk, List<List<Integer>> res) {
    res.add(chunk);
    for (int i = depth; i < nums.length; i++) {
      int curr = nums[i];
      if (i > depth && curr == nums[i - 1]) continue; // not return
      List<Integer> newChunk = new ArrayList<>(chunk);
      newChunk.add(curr);
      dfs(nums, i + 1, newChunk, res);
    }
  }

}
