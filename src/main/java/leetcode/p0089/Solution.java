package leetcode.p0089;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> grayCode(int n) {
    final List<Integer> result = new ArrayList<>();

    if (n == 0) {
      result.add(0);
      return result;
    }

    final List<Integer> prevResult = grayCode(n - 1);
    final int prevSize = 1 << (n - 1); // 2^(n-1)

    result.addAll(prevResult);

    for (int i = prevSize - 1; i >= 0; i--) {
      result.add(prevResult.get(i) + prevSize);
    }
    return result;
  }
}
