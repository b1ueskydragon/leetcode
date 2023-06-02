package leetcode.p0118.dpLoop;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // Pascal's Triangle
  public List<List<Integer>> generate(int numRows) {
    // base case
    final List<List<Integer>> res = new ArrayList<>() {{
      add(new ArrayList<>() {{
        add(1);
      }});
    }};

    for (int i = 1; i < numRows; i++) {
      final List<Integer> prevStep = res.get(i - 1);
      final List<Integer> currentStep = new ArrayList<>();
      currentStep.add(1);
      for (int j = 1; j < i; j++) {
        currentStep.add(prevStep.get(j - 1) + prevStep.get(j));
      }
      currentStep.add(1);
      res.add(currentStep);
    }

    return res;
  }
}
