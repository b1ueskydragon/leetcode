package leetcode.p0118.recursive;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // Pascal's Triangle
  public List<List<Integer>> generate(int numRows) {
    // base case
    if (numRows == 1) {
      return new ArrayList<>() {{
        add(new ArrayList<>() {{
          add(1);
        }});
      }};
    }

    final List<List<Integer>> generated = generate(numRows - 1);
    final List<Integer> prevStage = generated.get(numRows - 2);

    final List<Integer> newStage = new ArrayList<>();
    newStage.add(1);

    for (int i = 1; i < numRows - 1; i++) {
      newStage.add(prevStage.get(i - 1) + prevStage.get(i));
    }

    newStage.add(1);
    generated.add(newStage);

    return generated;
  }
}
