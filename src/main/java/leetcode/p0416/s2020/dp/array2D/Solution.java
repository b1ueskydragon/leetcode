package leetcode.p0416.s2020.dp.array2D;

// Containing only positive integers.
class Solution {
  private int sumOf(int[] nums) {
    int acc = 0;
    for (int num : nums) acc += num;
    return acc;
  }

  public boolean canPartition(int[] nums) {
    int sum = sumOf(nums);
    if (sum % 2 != 0) return false;
    int targetSum = sum / 2;
    int last = nums.length - 1;

    // isValidSoFar[i][S] := Memo whether S could be generated with any combination of nums so far (until i), or not.
    //                       nums[i] is not guaranteed be included always, and it's fine.
    //                       The 2D array has sentinel.
    final boolean[][] isValidSoFar = new boolean[last + 1][targetSum + 1];
    isValidSoFar[0][0] = true;

    // 2D array (matrix) searching. O(MN).
    // M is the targetSum, N is the length of the nums.
    for (int i = 1; i <= last; i++) {
      int num = nums[i];
      // targetSum + (targetSum - k) = targetSum.
      // the range of k should be [0, targetSum]
      for (int k = 0; k <= targetSum; k++) {
        if (k < num) {
          // current num exceeds k already, so just copy the latest result so far.
          // if is valid "until i-1", "until i" is always be true.
          isValidSoFar[i][k] = isValidSoFar[i - 1][k];
          continue;
        }
        // is valid "until i-1" OR will be valid if includes current num.
        isValidSoFar[i][k] = isValidSoFar[i - 1][k] || isValidSoFar[i - 1][k - num];

      }
    }
    return isValidSoFar[last][targetSum];
  }
}
