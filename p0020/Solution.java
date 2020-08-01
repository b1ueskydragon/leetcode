package leetcode.p0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
  final Map<Character, Character> pair = new HashMap<>() {{
    put('(', ')');
    put('{', '}');
    put('[', ']');
  }};
  final Stack<Character> matchResult = new Stack<>();

  public boolean isValid(String s) {
    for (char c : s.toCharArray()) {
      if (matchResult.isEmpty() && !pair.containsKey(c)) {
        // cannot build a pair.
        return false;
      }
      if (pair.containsKey(c)) {
        // key '(', '{', '[' part. just push.
        matchResult.push(c);
        continue;
      }
      // value ')', '}', ']' part. pop only if paired.
      if (!matchResult.isEmpty() &&
          c == pair.get(matchResult.peek())) {
        matchResult.pop();
      } else if (c != pair.get(matchResult.peek())) {
        // cannot build a pair.
        return false;
      }
    }
    return matchResult.isEmpty();
  }
}
