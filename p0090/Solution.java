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

  private void dfs(int[] nums, int pos, List<Integer> chunk, List<List<Integer>> res) {
    res.add(chunk);
    for (int i = pos; i < nums.length; i++) {
      int curr = nums[i];
      if (i > pos && curr == nums[i - 1]) continue; // not return
      List<Integer> newChunk = new ArrayList<>(chunk);
      newChunk.add(curr);
      dfs(nums, i + 1, newChunk, res);
    }
  }

}
