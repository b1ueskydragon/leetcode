package leetcode.p0240.simpleAndFast;

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
class Solution {
  // O(M+N), could return earlier.
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length - 1;
    int n = matrix[0].length - 1;

    int i = m;
    int j = 0;

    while (i >= 0 && j <= n) {
      int value = matrix[i][j];
      if (target < value) { // no target in matrix[i] row
        i--;
        continue;
      }
      if (target > value) {
        j++;
        continue;
      }
      return true; // target == value
    }
    return false;
  }
}
