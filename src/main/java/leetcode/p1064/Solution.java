package leetcode.p1064;

/**
 * Given an array A of distinct integers sorted in ascending order, return the smallest index i that satisfies A[i] == i.
 * Return -1 if no such i exists.
 */
class Solution {

  public int fixedPoint(int[] sortedAscArray) {
    int l = 0;
    int r = sortedAscArray.length - 1;

    while (l <= r) {
      int pi = l + (r - l) / 2; // left-align pivot
      int pv = sortedAscArray[pi];

      if (pi == pv) {
        return pi;
      }

      if (pi < pv) {
        r = pi - 1;
        continue;
      }

      l = pi + 1;
    }

    return -1;
  }
}
