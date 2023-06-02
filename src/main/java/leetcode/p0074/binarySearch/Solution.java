package leetcode.p0074.binarySearch;

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length - 1;
    int n = matrix[0].length - 1;
    int midRow = getStartRow(matrix, target, 0, m);
    if (midRow < 0) {
      return false;
    }
    return hasTarget(matrix[midRow], target, 0, n);
  }

  // binarySearch
  private int getStartRow(int[][] matrix,
                          int target,
                          int l,
                          int r) {
    while (l <= r) {
      int m = l + (r - l) / 2;
      int value = matrix[m][0];
      if (target < value) {
        r = m - 1;
        continue;
      }
      if (target > value) {
        l = m + 1;
        continue;
      }
      return m;
    }
    return r;
  }

  // binarySearch
  private boolean hasTarget(int[] array,
                            int target,
                            int l,
                            int r) {
    while (l <= r) {
      int m = l + (r - l) / 2;
      int value = array[m];
      if (target < value) {
        r = m - 1;
        continue;
      }
      if (target > value) {
        l = m + 1;
        continue;
      }
      return true;
    }
    return false;
  }

}
