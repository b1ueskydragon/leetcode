package leetcode.p0416.dp.array1D;

/**
 * Same idea based on
 *
 * @see leetcode.p0416.dp.array2D.Solution
 */
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

    final boolean[] isValidSoFar = new boolean[targetSum + 1];
    isValidSoFar[0] = true; // helps isValidSoFar[num] itself be true.

    // O(MN). M is the targetSum, N is the length of the nums.
    for (int num : nums) {
      // targetSum + (targetSum - k) = targetSum.
      // the range of k should be [0, targetSum]

      // Since the case of nums = {1, 2, 5}, regardless of the order, we'd like to check descending order.
      // This helps to prevent making isValidSoFar[2] (or isValidSoFar[4]) as true
      // even we're still in num=1 and don't know whether there is another num=1 (or num=2) or not.
      for (int k = targetSum; k >= num; k--) {
        // Since the nums is not sorted,
        // there's a chance to isValidSoFar[k] is checked already in a past num's turn.
        isValidSoFar[k] = isValidSoFar[k] || isValidSoFar[k - num];

        if (isValidSoFar[targetSum]) break;
      }
    }
    return isValidSoFar[targetSum];
  }
}
