package leetcode.p0215.s2020.divideAndConquer;


class Solution {
  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, k, 0, nums.length - 1);
  }

  private int quickSelect(int[] nums,
                          int k,
                          int l,
                          int r) {
    if (l == r) {
      return nums[l];
    }

    int p = l + (r - l) / 2;
    int pivot = nums[p];
    int i = l;
    int j = r;

    // sort reversed order
    while (i <= j) {
      while (nums[i] > pivot) {
        i++;
      }
      while (nums[j] < pivot) {
        j--;
      }

      if (i <= j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        // move cursor after swap
        i++;
        j--;
      }
    }

    int largers = j - l + 1; // the number of larger than kth (without any order)
    if (k <= largers) {
      return quickSelect(nums, k, l, j); // it's still possible that kth is in the range
    }

    // j < i
    largers = i - l;
    if (largers < k) {
      return quickSelect(nums, k - largers, i, r); // retrieve the other range and adjust `kth`
    }

    // e.g.) nums = [6, 5], k = 1
    return nums[j + 1];
  }
}
