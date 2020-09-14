package leetcode.p0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    final Map<Character, Character> table = new HashMap<>();
    table.put('(', ')');
    table.put('[', ']');
    table.put('{', '}');

    final Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (table.containsKey(c)) {
        stack.push(c);
        continue;
      }

      // since we don't push ')' ']' '}' in the stack.
      if (stack.isEmpty()) {
        return false;
      }

      if (c != table.get(stack.pop())) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
