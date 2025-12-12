package leetcode.p0836;

class Solution01 {
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

    boolean isWidthOverlapped = (g - a) > 0 && (c - e) > 0;
    boolean isHeightOverlapped = (h - b) > 0 && (d - f) > 0;

    return isWidthOverlapped && isHeightOverlapped;
  }
}
