package leetcode.p0997.hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  public int findJudge(int N, int[][] trust) {
    if (trust.length == 0 && N > 1) {
      return -1;
    }

    final Map<Integer, Set<Integer>> personToTrust = new HashMap<>();
    for (int[] pair : trust) {
      final int person = pair[0];
      final int maybeJudge = pair[1];

      if (personToTrust.containsKey(person)) {
        personToTrust.get(person).add(maybeJudge);
        continue;
      }
      final Set<Integer> candidates = new HashSet<>();
      candidates.add(maybeJudge);
      personToTrust.put(person, candidates);
    }


    if (personToTrust.keySet().size() < N - 1) {
      return -1;
    }

    int judge = -1;

    for (int i = 1; i <= N; i++) {
      if (!personToTrust.containsKey(i)) {
        judge = i;
        break;
      }
    }

    for (int person : personToTrust.keySet()) {
      if (!personToTrust.get(person).contains(judge)) {
        return -1;
      }
    }

    return judge;
  }
}
