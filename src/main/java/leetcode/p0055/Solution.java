package leetcode.p0055;

class Solution {
  public boolean canJump(int[] nums) {
    int goal = nums.length - 1; // dynamic goal.
    // think from the goal (count backwards).
    for (int i = goal - 1; i >= 0; i--) {
      // We should retrieve each point at least and at most once O(N),
      // since there is chance that the point bigger than goal exists
      if (i + nums[i] >= goal) {
        goal = i;
      }
    }
    // reached to start point or not after finish counting backwards.
    return goal == 0;
  }
}
