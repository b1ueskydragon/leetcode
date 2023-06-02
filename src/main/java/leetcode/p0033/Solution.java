package leetcode.p0033;

class Solution {
  // 1 <= nums.length
  // nums sorted in ascending order with distinct values and it's possibly rotated at an unknown pivot.
  // O(log n) time complexity is required.
  public int search(final int[] nums, final int target) {
    // find the smallest at first.
    final int pivot = findMinIndex(nums);
    final int last = nums.length - 1;

    if (nums[pivot] == target) {
      return pivot;
    }
    if (pivot == 0) {
      return binarySearch(nums, target, 0, last);
    }
    if (pivot == last) {
      return binarySearch(nums, target, 0, pivot - 1);
    }

    // nums[pivot - 1] > nums[pivot]
    if (nums[pivot] < target && target <= nums[last]) {
      return binarySearch(nums, target, pivot + 1, last);
    }
    return binarySearch(nums, target, 0, pivot);
  }

  // binary search
  private int findMinIndex(final int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      // if the distance is 2, left-side will be selected
      final int p = l + (r - l) / 2;
      // nums[p] is not a matter
      if (nums[l] < nums[r]) {
        return l;
      }
      if (nums[l] < nums[p] && nums[l] > nums[r]) {
        l = p + 1;
        continue;
      }
      if (nums[l] > nums[p] && nums[p] < nums[r]) {
        r = p;
        continue;
      }
      if (nums[l] > nums[p] && nums[l] > nums[r]) {
        l = p;
        continue;
      }
      assert r - l < 2;
      return (nums[l] < nums[r]) ? l : r;
    }
    return l;
  }

  private int binarySearch(final int[] nums, final int target, int l, int r) {
    while (l <= r) {
      final int p = l + (r - l) / 2;
      if (target > nums[p]) {
        l = p + 1;
        continue;
      }
      if (target < nums[p]) {
        r = p - 1;
        continue;
      }
      return p;
    }
    return -1;
  }
}
