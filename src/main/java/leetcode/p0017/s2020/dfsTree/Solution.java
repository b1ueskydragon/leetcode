package leetcode.p0017.s2020.dfsTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  private final List<String> res = new ArrayList<>();
  private final Map<Character, String> table = new HashMap<>();

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return res;
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
    dfs(digitsArray, 0, digitsArray.length, "");
    return res;
  }

  private void dfs(char[] digits, int currLevel, int maxDepth, String curr) {
    if (currLevel == maxDepth) {
      if (curr.length() == maxDepth) {
        res.add(curr);
      }
      return; // reached to the deepest leaf level.
    }

    final String levelToParents = table.get(digits[currLevel]);
    if (levelToParents == null) {
      return; // cannot build combinations.
    }

    final char[] parents = levelToParents.toCharArray();
    for (char node : parents) {
      String newNode = curr + node;
      dfs(digits, currLevel + 1, maxDepth, newNode); // left node builds new node.
      dfs(digits, currLevel + 1, maxDepth, curr); // right node just succeeds parent node.
    }
  }
}
