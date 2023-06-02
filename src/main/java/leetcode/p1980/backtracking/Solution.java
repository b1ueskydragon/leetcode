package leetcode.p1980.backtracking;

import java.util.Arrays;
import java.util.Set;

class Solution {
  private String str = "";

  public String findDifferentBinaryString(String[] nums) {
    final int n = nums.length;
    final char[] init = new char[n];
    Arrays.fill(init, '0');
    generateAndMatch(0, 0, n, init, Set.copyOf(Arrays.asList(nums)));
    return str;
  }

  // generate a single element and match
  private void generateAndMatch(int k,
                                int p,
                                int n,
                                char[] curr,
                                Set<String> table) {
    final String s = String.valueOf(curr);
    // make an early return
    if (!table.contains(s)) {
      str = s;
      return;
    }
    if (k == n) {
      return;
    }

    for (int i = p; i < n; i++) {
      final char[] next = Arrays.copyOf(curr, n);
      // bit reverse
      // '0' ^ 1 = '1', '1' ^ 1 = '0'
      next[i] ^= 1;
      // start from next horizontal level (i + 1)
      generateAndMatch(k + 1, i + 1, n, next, table);
    }
  }
}
