package leetcode.p0665;

class Solution {
  public boolean checkPossibility(int[] nums) {
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (count > 1) {
        return false;
      }
      if (nums[i - 1] <= nums[i]) {
        continue;
      }
      // There's only two choices to correct,
      // i) make a prev num smaller or equal to curr num (prev before >= prev after)
      // ii) make the curr num equal to previous num (curr before < curr after)
      // And the strategy is, we only compare the previous num since we only can make previous nums were already validated (to don't care previous nums)

      // Already valid. set the previous num smaller or same as current to keep previous validation
      // it's safe to adjust the previous num if the error was found at the beginning or nums[i - 2] == nums[i]
      if (i < 2 || nums[i - 2] <= nums[i]) {
        nums[i - 1] = nums[i];
      }
      // In the case of nums[i - 2] > nums[i],
      // even set the previous num smaller or same, the previous order will not be valid
      else {
        nums[i] = nums[i - 1];
      }
      count++;
    }
    return count <= 1;
  }
}
