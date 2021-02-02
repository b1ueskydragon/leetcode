package leetcode.p0179.mergeSort.inplace;

class Solution {
  // nums[i] might exceed the range of integer, but still not exceed the range of long.
  public String largestNumber(int[] nums) {
    mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
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

  // in-place
  private void mergeSort(int[] nums,
                         int l,
                         int r,
                         int[] cache) {

    // pointers are crossed or met.
    // single element, base case
    if (l >= r) {
      return;
    }

    // left-sided center (pick a left one if r-l is odd)
    int m = l + (r - l) / 2;

    // divide to two parts
    mergeSort(nums, l, m, cache);
    mergeSort(nums, m + 1, r, cache);

    int i = l; // current point of the origin nums

    // cache's cursor
    int cl = 0;
    int cr = 0;

    // build a sorted left-half [l, m]
    // and move cr to the end point of the left-half
    while (i <= m) {
      cache[cr++] = nums[i++];
    }

    int ni = l; // new i. current point of the nums which has new order

    // build a sorted right-half [m, r] while moving elements to the proper position.
    // at this point, cursor i should be at the start point of the right-half
    // and cr is at m-l+1 (same as length of the left-half)
    while (i <= r && cl < cr) {
      if (isLeftConcatLarger(cache[cl], nums[i])) {
        // if left-concat is larger, choose left-side's element
        nums[ni++] = cache[cl++];
        continue;
      }
      // else, choose right-side's element
      nums[ni++] = nums[i++];
    }

    // flush
    while (cl < cr) {
      nums[ni++] = cache[cl++];
    }
  }

  private boolean isLeftConcatLarger(int a, int b) {
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
