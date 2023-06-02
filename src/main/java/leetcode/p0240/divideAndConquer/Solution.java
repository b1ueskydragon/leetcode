package leetcode.p0240.divideAndConquer;

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    return searchMatrix(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
  }

  private boolean searchMatrix(int[][] matrix,
                               int target,
                               int rowStart,
                               int rowEnd,
                               int colStart,
                               int colEnd) {

    if (rowStart > rowEnd || colStart > colEnd) {
      return false;
    }

    int rowMid = rowStart + (rowEnd - rowStart) / 2;
    int colMid = colStart + (colEnd - colStart) / 2;
    int x = matrix[rowMid][colMid];

    if (target == x) {
      return true;
    }

    if (target < x) {
      // 3/4 of matrix
      return searchMatrix(matrix, target, rowStart, rowMid - 1, colStart, colEnd)
          || searchMatrix(matrix, target, rowMid, rowEnd, colStart, colMid - 1);
    }

    if (target > x) {
      // 3/4 of matrix
      return searchMatrix(matrix, target, rowStart, rowEnd, colMid + 1, colEnd)
          || searchMatrix(matrix, target, rowMid + 1, rowEnd, colStart, colMid);
    }

    return false;
  }
}
