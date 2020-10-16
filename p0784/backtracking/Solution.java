package leetcode.p0784.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<String> letterCasePermutation(String S) {
    final Map<Character, List<Character>> table = new HashMap<>();
    for (char c : S.toCharArray()) {
      final List<Character> alphas = new ArrayList<>();
      alphas.add(c);

      if (Character.isDigit(c)) {
        table.put(c, alphas);
        continue;
      }

      alphas.add(Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c));
      table.put(c, alphas);
    }

    return letterCasePermutation(S.toCharArray(), 0, table);
  }

  // make a different choice after return from the recursion of the level
  private List<String> letterCasePermutation(final char[] currArray,
                                             final int stage,
                                             final Map<Character, List<Character>> table) {

    final List<String> currStageRes = new ArrayList<>();
    if (stage == currArray.length) {
      currStageRes.add("");
      return currStageRes;
    }

    final List<Character> currStageCandidates = table.get(currArray[stage]);

    for (char candidate : currStageCandidates) {
      final List<String> prevStageCandidates = letterCasePermutation(currArray, stage + 1, table);
      for (String prevCand : prevStageCandidates) {
        currStageRes.add(candidate + prevCand);
      }
    }

    return currStageRes;
  }
}
