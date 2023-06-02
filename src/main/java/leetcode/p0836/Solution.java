package leetcode.p0836;

class Solution {
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    // bottom-left corner
    final int a = rec1[0];
    final int b = rec1[1];
    // top-right corner
    final int c = rec1[2];
    final int d = rec1[3];

    // bottom-left corner
    final int e = rec2[0];
    final int f = rec2[1];
    // top-right corner
    final int g = rec2[2];
    final int h = rec2[3];

    // rec2 is on the right
    if (c <= e) {
      return false;
    }
    // down
    if (h <= b) {
      return false;
    }
    // up
    if (d <= f) {
      return false;
    }
    // left
    if (g <= a) {
      return false;
    }

    return true;
  }
}
