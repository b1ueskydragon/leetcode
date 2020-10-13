package leetcode.p0017.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  private final Map<Character, String> table = new HashMap<>();

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }

    table.put('2', "abc");
    table.put('3', "def");
    table.put('4', "ghi");
    table.put('5', "jkl");
    table.put('6', "mno");
    table.put('7', "pqrs");
    table.put('8', "tuv");
    table.put('9', "wxyz");

    final char[] digitsArray = digits.toCharArray();
    return letterCombinations(digitsArray, 0);
  }

  // backtracking
  // make a different choice after return to the root
  private List<String> letterCombinations(final char[] digitsArray,
                                          final int stage) {

    final List<String> res = new ArrayList<>(); // result for current stage

    if (stage == digitsArray.length) {
      res.add("");
      return res;
    }

    final String currLetters = table.get(digitsArray[stage]);

    // keep to go ahead
    for (char currHead : currLetters.toCharArray()) {
      // System.out.println(currHead);
      final List<String> prevRes = letterCombinations(digitsArray, stage + 1);
      for (String node : prevRes) {
        res.add(currHead + node);
      }
    }
    return res;
  }
}
