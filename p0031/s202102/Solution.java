package leetcode.p0031.s202102;

class Solution {
  public void nextPermutation(int[] nums) {
    int last = nums.length - 1; // last (right most)
    int l = last - 1;
    int r = last; // previous position of l

    // l>=0; let l could be -1 (for special cases)
    while (l >= 0 && nums[l] >= nums[r]) {
      r = l;
      l--;
    }

    if (l >= 0) {
      // find the index of the smallest value, which can swap with nums[l] in range [r, last]
      int target = r;
      for (int i = r; i <= last; i++) {
        // nums[i]<=nums[target]; pick a right-most index if the values are same
        // to make (l, last] has descending order
        if (nums[i] > nums[l] && nums[i] <= nums[target]) {
          target = i;
        }
      }
      // swap the first decreasing elements
      swap(nums, l, target);
    }

    // sort by swapping both ends.
    // (l, last] is already sorted in descending order
    int start = l + 1;
    while (start <= last) {
      swap(nums, start++, last--);
    }
  }

  private void swap(int[] nums,
                    int i,
                    int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
