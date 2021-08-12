package leetcode.p0954;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
  public boolean canReorderDoubled(int[] arr) {
    final Map<Integer, Integer> countTable = new HashMap<>();
    for (int x : arr) {
      countTable.put(x, countTable.computeIfAbsent(x, key -> 0) + 1);
    }
    return canReorderDoubled(countTable);
  }

  // backtracking
  private boolean canReorderDoubled(Map<Integer, Integer> countTable) {
    final Set<Integer> numSet = countTable.keySet();
    for (int num : numSet) {

      if (countTable.get(num) == 0) {
        continue;
      }

      if (num % 2 == 0) {
        final int cand1 = num / 2;
        final int cand2 = num * 2;

        if (!numSet.contains(cand1) && !numSet.contains(cand2)) {
          return false;
        }

        if (numSet.contains(cand1) && countTable.get(cand1) > 0) {
          countTable.put(num, countTable.get(num) - 1);
          countTable.put(cand1, countTable.get(cand1) - 1);
          return canReorderDoubled(countTable);
        }

        if (numSet.contains(cand2) && countTable.get(cand2) > 0) {
          countTable.put(num, countTable.get(num) - 1);
          countTable.put(cand2, countTable.get(cand2) - 1);
          return canReorderDoubled(countTable);
        }

      } else {
        final int cand = num * 2;

        if (!numSet.contains(cand)) {
          return false;
        }

        if (countTable.get(cand) > 0) {
          countTable.put(num, countTable.get(num) - 1);
          countTable.put(cand, countTable.get(cand) - 1);
          return canReorderDoubled(countTable);
        }
      }
    }

    return countTable.values().stream().allMatch(v -> v == 0);
  }
}
