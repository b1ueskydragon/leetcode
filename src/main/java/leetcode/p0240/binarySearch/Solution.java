package leetcode.p0240.binarySearch;

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    final int rowSize = matrix[0].length;
    for (int[] row : matrix) {
      if (row[0] > target) {
        break;
      }

      boolean found = binarySearch(row, target, 0, rowSize - 1);
      if (found) {
        return true;
      }
    }

    return false;
  }

  private boolean binarySearch(int[] nums,
                               int target,
                               int l,
                               int r) {
    while (l <= r) {
      int m = l + (r - l) / 2;
      int pivot = nums[m];
      if (target == pivot) {
        return true;
      }
      if (target > pivot) {
        l = m + 1;
        continue;
      }
      r = m - 1;
    }
    return false;
  }
}
