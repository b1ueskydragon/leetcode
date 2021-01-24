package leetcode.p0179;

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 10^9
class Solution {
  // nums[i] might exceed the range of integer, but still not exceed the range of long.
  public String largestNumber(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
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

  private void quickSort(int[] nums,
                         int l,
                         int r) {
    int m = l + (r - l) / 2;
    int mid = nums[m];
    int pl = l;
    int pr = r;

    // do not divide until current pl and pr is crossed completely.
    while (pl <= pr) {
      while (isLeftConcatLarger(nums[pl], mid)) {
        pl++;
      }
      while (isLeftConcatLarger(mid, nums[pr])) {
        pr--;
      }
      if (pl <= pr) {
        swap(nums, pl, pr);
        // move cursor after swap for setting next position.
        pl++;
        pr--;
      }
    }
    if (l < pr) {
      quickSort(nums, l, pr);
    }
    if (pl < r) {
      quickSort(nums, pl, r);
    }
  }

  private boolean isLeftConcatLarger(int a, int b) {
    if (a == b) {
      return false; // since should not move cursors if a and b are equivalent.
    }
    StringBuilder as = new StringBuilder();
    StringBuilder bs = new StringBuilder();
    return as.append(a).append(b).toString().compareTo(bs.append(b).append(a).toString()) > -1;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
