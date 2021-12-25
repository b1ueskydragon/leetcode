package leetcode.p1980.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  private String str = "";

  public String findDifferentBinaryString(String[] nums) {
    final int n = nums.length;
    final char[] init = new char[n];
    for (int i = 0; i < n; i++) {
      init[i] = '0';
    }
    final Set<String> table = new HashSet<>() {{
      addAll(Arrays.asList(nums));
    }};
    generateAndMatch(0, 0, n, init, table);
    return str;
  }

  // generate a single element and match
  private char[] generateAndMatch(int k,
                                  int p,
                                  int n,
                                  char[] curr,
                                  Set<String> table) {
    final String s = String.valueOf(curr);
    // make an early return
    if (!table.contains(s)) {
      str = s;
      return curr;
    }
    if (k == n) {
      return curr;
    }

    for (int i = p; i < n; i++) {
      final char[] next = Arrays.copyOf(curr, n);

      // bit reverse
      // '0' ^ 1 = '1', '1' ^ 1 = '0'
      next[i] ^= 1;

      // start from next horizontal level (i + 1)
      generateAndMatch(k + 1, i + 1, n, next, table);
    }

    return curr;
  }
}
