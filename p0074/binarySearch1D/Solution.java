package leetcode.p0074.binarySearch1D;

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
class Solution {
  // treat as a 1D array
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    int left = 0;
    int right = m * n - 1;

    while (left <= right) {
      int pivot = left + (right - left) / 2;
      // a coordinate of p
      int r = pivot / n;
      int c = pivot % n;
      // get a middle coordinate dynamically.
      int value = matrix[r][c];

      if (target > value) {
        left = pivot + 1;
        continue;
      }
      if (target < value) {
        right = pivot - 1;
        continue;
      }
      return true;
    }

    return false;
  }
}
