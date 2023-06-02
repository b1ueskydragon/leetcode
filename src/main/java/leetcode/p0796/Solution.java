package leetcode.p0796;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public boolean rotateString(String A, String B) {
    int size = A.length();
    if (B.length() != size) {
      return false;
    }
    if (size == 0) {
      return true;
    }

    final char[] as = A.toCharArray();
    final char[] bs = B.toCharArray();

    final char head = bs[0];

    // candidates of start points
    final List<Integer> candidates = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      if (head == as[i]) {
        candidates.add(i);
      }
    }

    for (int index : candidates) {
      if (rotateString(as, bs, size, index)) {
        return true;
      }
    }
    return false;
  }

  private boolean rotateString(final char[] as,
                               final char[] bs,
                               final int size,
                               final int index) {
    int i = 0;
    int a = index;
    int b = 0;

    // move the position to compare right half
    while (size > a && as[a] == bs[b]) {
      a++;
      b++;
    }

    // move the position to compare left half
    while (size > b && as[i] == bs[b]) {
      i++;
      b++;
    }

    // if b reached to the end, strings are matched
    return b == size;
  }

}
