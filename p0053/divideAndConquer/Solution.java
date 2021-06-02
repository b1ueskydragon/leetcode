package leetcode.p0053.divideAndConquer;

class Solution {
  public int maxSubArray(int[] nums) {
    return maxSubArray(nums, 0, nums.length - 1);
  }

  private int maxSubArray(int[] nums,
                          int left,
                          int right) {
    if (left > right) {
      return Integer.MIN_VALUE;
    }

    final int mid = left + (right - left) / 2;

    // left half without current mid
    final int maxLeft = maxSubArray(nums, left, mid - 1);

    // right half without current mid
    final int maxRight = maxSubArray(nums, mid + 1, right);

    // check the reverse direction (<-) without current mid
    int maxLeftAdjacentMid = 0;
    for (int i = mid - 1, soFar = 0; i >= left; i--) {
      soFar += nums[i];
      maxLeftAdjacentMid = Math.max(maxLeftAdjacentMid, soFar);
    }

    // check the reverse direction (->) without current mid
    int maxRightAdjacentMid = 0;
    for (int i = mid + 1, soFar = 0; i <= right; i++) {
      soFar += nums[i];
      maxRightAdjacentMid = Math.max(maxRightAdjacentMid, soFar);
    }

    // check both halfs first
    final int maxExclMid = Math.max(maxLeft, maxRight);

    // now sum-up a mid
    final int maxInclMid = maxLeftAdjacentMid + nums[mid] + maxRightAdjacentMid;

    // and compare
    return Math.max(maxExclMid, maxInclMid);
  }
}
