package leetcode.p0179.mergeSort.additionalSpace;

import java.util.Arrays;

class Solution {
  // nums[i] might exceed the range of integer, but still not exceed the range of long.
  public String largestNumber(int[] nums) {
    nums = mergeSort(nums);
    // all-zero array. check after the array is sorted.
    if (nums[0] == 0) {
      return "0";
    }

    StringBuilder res = new StringBuilder();
    for (int num : nums) {
      res.append(num);
    }
    return res.toString();
  }

  private int[] mergeSort(int[] nums) {
    // base case
    if (nums.length < 2) {
      return nums;
    }
    // divide and merge sorted two lists
    int m = nums.length / 2;
    return merge(mergeSort(Arrays.copyOfRange(nums, 0, m)), mergeSort(Arrays.copyOfRange(nums, m, nums.length)));
  }

  private int[] merge(final int[] sortedXs,
                      final int[] sortedYs) {
    int i = 0;
    int j = 0;
    int nx = sortedXs.length;
    int ny = sortedYs.length;

    int[] merged = new int[nx + ny];
    int p = 0;

    while (i < nx && j < ny) {
      if (isLeftConcatLarger(sortedXs[i], sortedYs[j])) {
        merged[p] = sortedXs[i];
        i++;
      } else {
        merged[p] = sortedYs[j];
        j++;
      }
      p++;
    }

    // flush
    while (i < nx) {
      merged[p++] = sortedXs[i++];
    }
    while (j < ny) {
      merged[p++] = sortedYs[j++];
    }

    return merged;
  }


  private boolean isLeftConcatLarger(int a, int b) {
    if (a == b) {
      return false; // since should not move cursors if a and b are equivalent.
    }
    int aDigit = getDigit(a);
    int bDigit = getDigit(b);

    long aLeft = (long) (a * Math.pow(10, bDigit) + b);
    long bLeft = (long) (b * Math.pow(10, aDigit) + a);

    return aLeft > bLeft;
  }

  private int getDigit(int num) {
    if (num == 0) {
      return 1;
    }

    int digit = 0;
    while (num > 0) {
      num /= 10;
      digit++;
    }
    return digit;
  }

}
