package leetcode.p0020;

import java.util.Map;
import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    final Stack<Character> stack = new Stack<>();
    final Map<Character, Character> pairs =
        Map.of('(', ')',
            '{', '}',
            '[', ']');
    int i = 0;
    while (i < s.length()) {
      final char x = s.charAt(i++);
      if (pairs.containsKey(x)) {
        stack.push(x);
        continue;
      }
      // there's no open-bracket to pop even the close-bracket arrived
      if (stack.isEmpty()) {
        return false;
      }
      if (pairs.get(stack.pop()) != x) {
        return false;
      }
    }
    // all of open-brackets should be popped
    return stack.isEmpty();
  }
}
