package leetcode.p1470.inPlaceSwap;

class Solution {
  // nums.length == 2n
  public int[] shuffle(int[] nums, int n) {
    // initial position is last-1 th index.
    int end = (2 * n) - 2;

    // Narrowing the swapping range.
    // in the 1st for-loop, move ys to left (odd i th is ys's turn),
    // in the 2nd for-loop, move xs to left (even i th is xs's turn),
    // ...
    // When i reaches to n, shuffle is done.
    for (int i = 1; i < n; i++) {
      int start = i;
      int target = n;
      while (start < n) {
        swap(nums, start, target);
        start++;
        target++;
      }
      end--;
    }
    return nums;
  }

  private static void swap(final int[] nums,
                           final int i,
                           final int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
